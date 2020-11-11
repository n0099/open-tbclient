package com.baidu.tieba.homepage.gamevideo.b;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eIc;
    private RelativeLayout fYQ;
    private ImageView gQD;
    private RelativeLayout gmv;
    private GameVideoGridView jAi;
    private com.baidu.tieba.homepage.gamevideo.a.b jAj;
    private com.baidu.tieba.homepage.gamevideo.view.a jAm;
    private TextView jAn;
    private a jAo;
    private TranslateAnimation jAp;
    private TranslateAnimation jAq;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jAr = false;
    private Animation.AnimationListener jAs = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jAr = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jAr = false;
            b.this.cKa();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jAj != null && i < b.this.jAj.getCount() && b.this.jAj.getItem(i) != null && (b.this.jAj.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jAj.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jAo != null) {
                        b.this.jAo.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bqh().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cKa();
                    TiebaStatic.log(new aq("c13489").al("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cJZ();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jAo != null) {
                b.this.jAo.cKd();
            }
        }
    };
    private a.InterfaceC0741a jAt = new a.InterfaceC0741a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0741a
        public void cKb() {
            b.this.cJY();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cKc();

        void cKd();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eIc = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eIc.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gmv = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fYQ = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gQD = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jAn = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jAi = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jAi.setMaxHeight(l.getEquipmentWidth(this.eIc.getPageActivity()));
        this.jAi.setNumColumns(4);
        this.jAi.setEmptyView(this.fYQ);
        this.jAj = new com.baidu.tieba.homepage.gamevideo.a.b(this.eIc, 102, this.mBdUniqueId);
        this.jAi.setAdapter((ListAdapter) this.jAj);
        this.jAi.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cJX();
        onChangeSkinType();
    }

    private void cJX() {
        this.jAp = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jAp.setDuration(300L);
        this.jAp.setFillAfter(true);
        this.jAp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jAq = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jAq.setDuration(200L);
        this.jAq.setFillAfter(true);
        this.jAq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jAq.setAnimationListener(this.jAs);
    }

    public void BE(int i) {
        if (this.jAj != null) {
            this.jAj.BE(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gmv != null) {
            ap.setBackgroundResource(this.gmv, R.color.cp_bg_line_d);
        }
        if (this.jAn != null) {
            ap.setViewTextColor(this.jAn, R.color.cp_cont_d);
        }
        if (this.gQD != null) {
            ap.setImageResource(this.gQD, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jAj.setData(list);
    }

    public void cL(View view) {
        if (view != null) {
            this.jAj.notifyDataSetChanged();
            if (this.jAm == null) {
                this.jAm = new com.baidu.tieba.homepage.gamevideo.view.a(this.eIc, this.mRootView, -1, -1);
                this.jAm.setBackgroundDrawable(new ColorDrawable(this.eIc.getResources().getColor(R.color.black_alpha66)));
                this.jAm.setAnimationStyle(0);
                this.jAm.a(this.jAt);
                this.jAm.setFocusable(true);
                this.jAm.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jAm.isShowing()) {
                this.jAm.dismiss();
            }
            this.jAm.showAsDropDown(view, 0, 0);
            this.jAi.cKk();
            if (this.gmv != null && this.jAp != null) {
                this.gmv.startAnimation(this.jAp);
            }
            if (this.jAo != null) {
                this.jAo.cKc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJY() {
        if (this.jAq != null && this.gmv != null && !this.jAr) {
            this.gmv.startAnimation(this.jAq);
        }
    }

    public void cJZ() {
        if (this.jAm != null) {
            this.jAm.dismiss();
        }
    }

    public void cKa() {
        if (this.jAm != null) {
            this.jAm.Xa();
        }
    }

    public boolean isShowing() {
        if (this.jAm != null) {
            return this.jAm.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jAo = aVar;
    }

    public void onDestroy() {
        cKa();
        if (this.jAp != null) {
            this.jAp.cancel();
        }
        if (this.jAq != null) {
            this.jAq.cancel();
        }
        if (this.jAi != null) {
            this.jAi.onDestroy();
        }
    }
}

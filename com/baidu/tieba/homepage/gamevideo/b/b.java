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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext dIF;
    private RelativeLayout eUB;
    private ImageView fEW;
    private RelativeLayout ffj;
    private GameVideoGridView ibm;
    private com.baidu.tieba.homepage.gamevideo.a.b ibn;
    private com.baidu.tieba.homepage.gamevideo.view.a ibq;
    private TextView ibr;
    private a ibs;
    private TranslateAnimation ibt;
    private TranslateAnimation ibu;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean ibv = false;
    private Animation.AnimationListener ibw = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ibv = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ibv = false;
            b.this.cfv();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ibn != null && i < b.this.ibn.getCount() && b.this.ibn.getItem(i) != null && (b.this.ibn.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ibn.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ibs != null) {
                        b.this.ibs.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aTX().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cfv();
                    TiebaStatic.log(new an("c13489").ag("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cfu();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ibs != null) {
                b.this.ibs.cfy();
            }
        }
    };
    private a.InterfaceC0626a ibx = new a.InterfaceC0626a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0626a
        public void cfw() {
            b.this.cft();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cfx();

        void cfy();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.dIF.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.ffj = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.eUB = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fEW = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ibr = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ibm = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ibm.setMaxHeight(l.getEquipmentWidth(this.dIF.getPageActivity()));
        this.ibm.setNumColumns(4);
        this.ibm.setEmptyView(this.eUB);
        this.ibn = new com.baidu.tieba.homepage.gamevideo.a.b(this.dIF, 102, this.mBdUniqueId);
        this.ibm.setAdapter((ListAdapter) this.ibn);
        this.ibm.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cfs();
        onChangeSkinType();
    }

    private void cfs() {
        this.ibt = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ibt.setDuration(300L);
        this.ibt.setFillAfter(true);
        this.ibt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ibu = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ibu.setDuration(200L);
        this.ibu.setFillAfter(true);
        this.ibu.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ibu.setAnimationListener(this.ibw);
    }

    public void wz(int i) {
        if (this.ibn != null) {
            this.ibn.wz(i);
        }
    }

    public void onChangeSkinType() {
        if (this.ffj != null) {
            am.setBackgroundResource(this.ffj, R.color.cp_bg_line_d);
        }
        if (this.ibr != null) {
            am.setViewTextColor(this.ibr, (int) R.color.cp_cont_d);
        }
        if (this.fEW != null) {
            am.setImageResource(this.fEW, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ibn.setData(list);
    }

    public void cg(View view) {
        if (view != null) {
            this.ibn.notifyDataSetChanged();
            if (this.ibq == null) {
                this.ibq = new com.baidu.tieba.homepage.gamevideo.view.a(this.dIF, this.mRootView, -1, -1);
                this.ibq.setBackgroundDrawable(new ColorDrawable(this.dIF.getResources().getColor(R.color.black_alpha66)));
                this.ibq.setAnimationStyle(0);
                this.ibq.a(this.ibx);
                this.ibq.setFocusable(true);
                this.ibq.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ibq.isShowing()) {
                this.ibq.dismiss();
            }
            this.ibq.showAsDropDown(view, 0, 0);
            this.ibm.cfF();
            if (this.ffj != null && this.ibt != null) {
                this.ffj.startAnimation(this.ibt);
            }
            if (this.ibs != null) {
                this.ibs.cfx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cft() {
        if (this.ibu != null && this.ffj != null && !this.ibv) {
            this.ffj.startAnimation(this.ibu);
        }
    }

    public void cfu() {
        if (this.ibq != null) {
            this.ibq.dismiss();
        }
    }

    public void cfv() {
        if (this.ibq != null) {
            this.ibq.bsd();
        }
    }

    public boolean isShowing() {
        if (this.ibq != null) {
            return this.ibq.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ibs = aVar;
    }

    public void onDestroy() {
        cfv();
        if (this.ibt != null) {
            this.ibt.cancel();
        }
        if (this.ibu != null) {
            this.ibu.cancel();
        }
        if (this.ibm != null) {
            this.ibm.onDestroy();
        }
    }
}

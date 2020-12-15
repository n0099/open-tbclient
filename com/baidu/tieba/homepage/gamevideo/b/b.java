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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eNx;
    private ImageView gZz;
    private RelativeLayout ggK;
    private RelativeLayout gun;
    private GameVideoGridView jOI;
    private com.baidu.tieba.homepage.gamevideo.a.b jOJ;
    private com.baidu.tieba.homepage.gamevideo.view.a jOM;
    private TextView jON;
    private a jOO;
    private TranslateAnimation jOP;
    private TranslateAnimation jOQ;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jOR = false;
    private Animation.AnimationListener jOS = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jOR = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jOR = false;
            b.this.cOV();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jOJ != null && i < b.this.jOJ.getCount() && b.this.jOJ.getItem(i) != null && (b.this.jOJ.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jOJ.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jOO != null) {
                        b.this.jOO.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cOV();
                    TiebaStatic.log(new ar("c13489").al("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cOU();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jOO != null) {
                b.this.jOO.cOY();
            }
        }
    };
    private a.InterfaceC0760a jOT = new a.InterfaceC0760a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0760a
        public void cOW() {
            b.this.cOT();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cOX();

        void cOY();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eNx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gun = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ggK = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gZz = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jON = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jOI = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jOI.setMaxHeight(l.getEquipmentWidth(this.eNx.getPageActivity()));
        this.jOI.setNumColumns(4);
        this.jOI.setEmptyView(this.ggK);
        this.jOJ = new com.baidu.tieba.homepage.gamevideo.a.b(this.eNx, 102, this.mBdUniqueId);
        this.jOI.setAdapter((ListAdapter) this.jOJ);
        this.jOI.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cOS();
        onChangeSkinType();
    }

    private void cOS() {
        this.jOP = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jOP.setDuration(300L);
        this.jOP.setFillAfter(true);
        this.jOP.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jOQ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jOQ.setDuration(200L);
        this.jOQ.setFillAfter(true);
        this.jOQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jOQ.setAnimationListener(this.jOS);
    }

    public void CR(int i) {
        if (this.jOJ != null) {
            this.jOJ.CR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gun != null) {
            ap.setBackgroundResource(this.gun, R.color.CAM_X0201);
        }
        if (this.jON != null) {
            ap.setViewTextColor(this.jON, R.color.CAM_X0109);
        }
        if (this.gZz != null) {
            ap.setImageResource(this.gZz, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jOJ.setData(list);
    }

    public void cW(View view) {
        if (view != null) {
            this.jOJ.notifyDataSetChanged();
            if (this.jOM == null) {
                this.jOM = new com.baidu.tieba.homepage.gamevideo.view.a(this.eNx, this.mRootView, -1, -1);
                this.jOM.setBackgroundDrawable(new ColorDrawable(this.eNx.getResources().getColor(R.color.black_alpha66)));
                this.jOM.setAnimationStyle(0);
                this.jOM.a(this.jOT);
                this.jOM.setFocusable(true);
                this.jOM.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jOM.isShowing()) {
                this.jOM.dismiss();
            }
            this.jOM.showAsDropDown(view, 0, 0);
            this.jOI.cPf();
            if (this.gun != null && this.jOP != null) {
                this.gun.startAnimation(this.jOP);
            }
            if (this.jOO != null) {
                this.jOO.cOX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOT() {
        if (this.jOQ != null && this.gun != null && !this.jOR) {
            this.gun.startAnimation(this.jOQ);
        }
    }

    public void cOU() {
        if (this.jOM != null) {
            this.jOM.dismiss();
        }
    }

    public void cOV() {
        if (this.jOM != null) {
            this.jOM.YQ();
        }
    }

    public boolean isShowing() {
        if (this.jOM != null) {
            return this.jOM.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jOO = aVar;
    }

    public void onDestroy() {
        cOV();
        if (this.jOP != null) {
            this.jOP.cancel();
        }
        if (this.jOQ != null) {
            this.jOQ.cancel();
        }
        if (this.jOI != null) {
            this.jOI.onDestroy();
        }
    }
}

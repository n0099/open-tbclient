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
/* loaded from: classes21.dex */
public class b {
    private TbPageContext ehG;
    private RelativeLayout fKm;
    private RelativeLayout fyA;
    private ImageView gkK;
    private GameVideoGridView iSQ;
    private com.baidu.tieba.homepage.gamevideo.a.b iSR;
    private com.baidu.tieba.homepage.gamevideo.view.a iSU;
    private TextView iSV;
    private a iSW;
    private TranslateAnimation iSX;
    private TranslateAnimation iSY;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean iSZ = false;
    private Animation.AnimationListener iTa = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.iSZ = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.iSZ = false;
            b.this.cAL();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.iSR != null && i < b.this.iSR.getCount() && b.this.iSR.getItem(i) != null && (b.this.iSR.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.iSR.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.iSW != null) {
                        b.this.iSW.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bjf().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cAL();
                    TiebaStatic.log(new aq("c13489").ai("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cAK();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.iSW != null) {
                b.this.iSW.cAO();
            }
        }
    };
    private a.InterfaceC0693a iTb = new a.InterfaceC0693a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0693a
        public void cAM() {
            b.this.cAJ();
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cAN();

        void cAO();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.ehG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.ehG.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fKm = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fyA = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gkK = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.iSV = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.iSQ = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.iSQ.setMaxHeight(l.getEquipmentWidth(this.ehG.getPageActivity()));
        this.iSQ.setNumColumns(4);
        this.iSQ.setEmptyView(this.fyA);
        this.iSR = new com.baidu.tieba.homepage.gamevideo.a.b(this.ehG, 102, this.mBdUniqueId);
        this.iSQ.setAdapter((ListAdapter) this.iSR);
        this.iSQ.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cAI();
        onChangeSkinType();
    }

    private void cAI() {
        this.iSX = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.iSX.setDuration(300L);
        this.iSX.setFillAfter(true);
        this.iSX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iSY = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.iSY.setDuration(200L);
        this.iSY.setFillAfter(true);
        this.iSY.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iSY.setAnimationListener(this.iTa);
    }

    public void As(int i) {
        if (this.iSR != null) {
            this.iSR.As(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fKm != null) {
            ap.setBackgroundResource(this.fKm, R.color.cp_bg_line_d);
        }
        if (this.iSV != null) {
            ap.setViewTextColor(this.iSV, R.color.cp_cont_d);
        }
        if (this.gkK != null) {
            ap.setImageResource(this.gkK, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.iSR.setData(list);
    }

    public void cy(View view) {
        if (view != null) {
            this.iSR.notifyDataSetChanged();
            if (this.iSU == null) {
                this.iSU = new com.baidu.tieba.homepage.gamevideo.view.a(this.ehG, this.mRootView, -1, -1);
                this.iSU.setBackgroundDrawable(new ColorDrawable(this.ehG.getResources().getColor(R.color.black_alpha66)));
                this.iSU.setAnimationStyle(0);
                this.iSU.a(this.iTb);
                this.iSU.setFocusable(true);
                this.iSU.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.iSU.isShowing()) {
                this.iSU.dismiss();
            }
            this.iSU.showAsDropDown(view, 0, 0);
            this.iSQ.cAV();
            if (this.fKm != null && this.iSX != null) {
                this.fKm.startAnimation(this.iSX);
            }
            if (this.iSW != null) {
                this.iSW.cAN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAJ() {
        if (this.iSY != null && this.fKm != null && !this.iSZ) {
            this.fKm.startAnimation(this.iSY);
        }
    }

    public void cAK() {
        if (this.iSU != null) {
            this.iSU.dismiss();
        }
    }

    public void cAL() {
        if (this.iSU != null) {
            this.iSU.RH();
        }
    }

    public boolean isShowing() {
        if (this.iSU != null) {
            return this.iSU.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.iSW = aVar;
    }

    public void onDestroy() {
        cAL();
        if (this.iSX != null) {
            this.iSX.cancel();
        }
        if (this.iSY != null) {
            this.iSY.cancel();
        }
        if (this.iSQ != null) {
            this.iSQ.onDestroy();
        }
    }
}

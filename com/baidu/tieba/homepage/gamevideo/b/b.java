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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eXu;
    private RelativeLayout gFm;
    private RelativeLayout gri;
    private ImageView hlo;
    private GameVideoGridView kbW;
    private com.baidu.tieba.homepage.gamevideo.a.b kbX;
    private com.baidu.tieba.homepage.gamevideo.view.a kca;
    private TextView kcb;
    private a kcc;
    private TranslateAnimation kcd;
    private TranslateAnimation kce;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean kcf = false;
    private Animation.AnimationListener kcg = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.kcf = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.kcf = false;
            b.this.cSc();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.kbX != null && i < b.this.kbX.getCount() && b.this.kbX.getItem(i) != null && (b.this.kbX.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.kbX.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.kcc != null) {
                        b.this.kcc.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bvr().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bvr().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cSc();
                    TiebaStatic.log(new aq("c13489").an("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cSb();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.kcc != null) {
                b.this.kcc.cSf();
            }
        }
    };
    private a.InterfaceC0761a kch = new a.InterfaceC0761a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0761a
        public void cSd() {
            b.this.cSa();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cSe();

        void cSf();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eXu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gFm = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.gri = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.hlo = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.kcb = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.kbW = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.kbW.setMaxHeight(l.getEquipmentWidth(this.eXu.getPageActivity()));
        this.kbW.setNumColumns(4);
        this.kbW.setEmptyView(this.gri);
        this.kbX = new com.baidu.tieba.homepage.gamevideo.a.b(this.eXu, 102, this.mBdUniqueId);
        this.kbW.setAdapter((ListAdapter) this.kbX);
        this.kbW.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cRZ();
        onChangeSkinType();
    }

    private void cRZ() {
        this.kcd = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.kcd.setDuration(300L);
        this.kcd.setFillAfter(true);
        this.kcd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kce = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.kce.setDuration(200L);
        this.kce.setFillAfter(true);
        this.kce.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kce.setAnimationListener(this.kcg);
    }

    public void Df(int i) {
        if (this.kbX != null) {
            this.kbX.Df(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gFm != null) {
            ao.setBackgroundResource(this.gFm, R.color.CAM_X0201);
        }
        if (this.kcb != null) {
            ao.setViewTextColor(this.kcb, R.color.CAM_X0109);
        }
        if (this.hlo != null) {
            ao.setImageResource(this.hlo, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.kbX.setData(list);
    }

    public void dg(View view) {
        if (view != null) {
            this.kbX.notifyDataSetChanged();
            if (this.kca == null) {
                this.kca = new com.baidu.tieba.homepage.gamevideo.view.a(this.eXu, this.mRootView, -1, -1);
                this.kca.setBackgroundDrawable(new ColorDrawable(this.eXu.getResources().getColor(R.color.black_alpha66)));
                this.kca.setAnimationStyle(0);
                this.kca.a(this.kch);
                this.kca.setFocusable(true);
                this.kca.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.kca.isShowing()) {
                this.kca.dismiss();
            }
            this.kca.showAsDropDown(view, 0, 0);
            this.kbW.cSm();
            if (this.gFm != null && this.kcd != null) {
                this.gFm.startAnimation(this.kcd);
            }
            if (this.kcc != null) {
                this.kcc.cSe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSa() {
        if (this.kce != null && this.gFm != null && !this.kcf) {
            this.gFm.startAnimation(this.kce);
        }
    }

    public void cSb() {
        if (this.kca != null) {
            this.kca.dismiss();
        }
    }

    public void cSc() {
        if (this.kca != null) {
            this.kca.aah();
        }
    }

    public boolean isShowing() {
        if (this.kca != null) {
            return this.kca.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.kcc = aVar;
    }

    public void onDestroy() {
        cSc();
        if (this.kcd != null) {
            this.kcd.cancel();
        }
        if (this.kce != null) {
            this.kce.cancel();
        }
        if (this.kbW != null) {
            this.kbW.onDestroy();
        }
    }
}

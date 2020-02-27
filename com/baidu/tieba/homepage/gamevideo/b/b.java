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
    private TbPageContext cVg;
    private ImageView eLK;
    private RelativeLayout ehr;
    private RelativeLayout eoj;
    private GameVideoGridView haG;
    private com.baidu.tieba.homepage.gamevideo.a.b haH;
    private com.baidu.tieba.homepage.gamevideo.view.a haK;
    private TextView haL;
    private a haM;
    private TranslateAnimation haN;
    private TranslateAnimation haO;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean haP = false;
    private Animation.AnimationListener haQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.haP = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.haP = false;
            b.this.bOa();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.haH != null && i < b.this.haH.getCount() && b.this.haH.getItem(i) != null && (b.this.haH.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.haH.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.haM != null) {
                        b.this.haM.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFB().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aFB().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bOa();
                    TiebaStatic.log(new an("c13489").X("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bNZ();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.haM != null) {
                b.this.haM.bOd();
            }
        }
    };
    private a.InterfaceC0518a haR = new a.InterfaceC0518a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0518a
        public void bOb() {
            b.this.bNY();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bOc();

        void bOd();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVg = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cVg.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eoj = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ehr = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eLK = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.haL = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.haG = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.haG.setMaxHeight(l.getEquipmentWidth(this.cVg.getPageActivity()));
        this.haG.setNumColumns(4);
        this.haG.setEmptyView(this.ehr);
        this.haH = new com.baidu.tieba.homepage.gamevideo.a.b(this.cVg, 102, this.mBdUniqueId);
        this.haG.setAdapter((ListAdapter) this.haH);
        this.haG.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bNX();
        onChangeSkinType();
    }

    private void bNX() {
        this.haN = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.haN.setDuration(300L);
        this.haN.setFillAfter(true);
        this.haN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.haO = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.haO.setDuration(200L);
        this.haO.setFillAfter(true);
        this.haO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.haO.setAnimationListener(this.haQ);
    }

    public void vm(int i) {
        if (this.haH != null) {
            this.haH.vm(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eoj != null) {
            am.setBackgroundResource(this.eoj, R.color.cp_bg_line_d);
        }
        if (this.haL != null) {
            am.setViewTextColor(this.haL, (int) R.color.cp_cont_d);
        }
        if (this.eLK != null) {
            am.setImageResource(this.eLK, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.haH.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.haH.notifyDataSetChanged();
            if (this.haK == null) {
                this.haK = new com.baidu.tieba.homepage.gamevideo.view.a(this.cVg, this.mRootView, -1, -1);
                this.haK.setBackgroundDrawable(new ColorDrawable(this.cVg.getResources().getColor(R.color.black_alpha66)));
                this.haK.setAnimationStyle(0);
                this.haK.a(this.haR);
                this.haK.setFocusable(true);
                this.haK.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.haK.isShowing()) {
                this.haK.dismiss();
            }
            this.haK.showAsDropDown(view, 0, 0);
            this.haG.bOk();
            if (this.eoj != null && this.haN != null) {
                this.eoj.startAnimation(this.haN);
            }
            if (this.haM != null) {
                this.haM.bOc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNY() {
        if (this.haO != null && this.eoj != null && !this.haP) {
            this.eoj.startAnimation(this.haO);
        }
    }

    public void bNZ() {
        if (this.haK != null) {
            this.haK.dismiss();
        }
    }

    public void bOa() {
        if (this.haK != null) {
            this.haK.bdG();
        }
    }

    public boolean isShowing() {
        if (this.haK != null) {
            return this.haK.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.haM = aVar;
    }

    public void onDestroy() {
        bOa();
        if (this.haN != null) {
            this.haN.cancel();
        }
        if (this.haO != null) {
            this.haO.cancel();
        }
        if (this.haG != null) {
            this.haG.onDestroy();
        }
    }
}

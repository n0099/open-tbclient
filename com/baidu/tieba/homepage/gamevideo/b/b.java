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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext dVN;
    private ImageView fVy;
    private RelativeLayout fjP;
    private RelativeLayout fvE;
    private GameVideoGridView ivN;
    private com.baidu.tieba.homepage.gamevideo.a.b ivO;
    private com.baidu.tieba.homepage.gamevideo.view.a ivR;
    private TextView ivS;
    private a ivT;
    private TranslateAnimation ivU;
    private TranslateAnimation ivV;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean ivW = false;
    private Animation.AnimationListener ivX = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ivW = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ivW = false;
            b.this.cmt();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ivO != null && i < b.this.ivO.getCount() && b.this.ivO.getItem(i) != null && (b.this.ivO.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ivO.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ivT != null) {
                        b.this.ivT.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aZP().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cmt();
                    TiebaStatic.log(new ap("c13489").ah("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cms();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ivT != null) {
                b.this.ivT.cmw();
            }
        }
    };
    private a.InterfaceC0645a ivY = new a.InterfaceC0645a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0645a
        public void cmu() {
            b.this.cmr();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cmv();

        void cmw();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dVN = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.dVN.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fvE = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fjP = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fVy = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ivS = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ivN = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ivN.setMaxHeight(l.getEquipmentWidth(this.dVN.getPageActivity()));
        this.ivN.setNumColumns(4);
        this.ivN.setEmptyView(this.fjP);
        this.ivO = new com.baidu.tieba.homepage.gamevideo.a.b(this.dVN, 102, this.mBdUniqueId);
        this.ivN.setAdapter((ListAdapter) this.ivO);
        this.ivN.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cmq();
        onChangeSkinType();
    }

    private void cmq() {
        this.ivU = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ivU.setDuration(300L);
        this.ivU.setFillAfter(true);
        this.ivU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ivV = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ivV.setDuration(200L);
        this.ivV.setFillAfter(true);
        this.ivV.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ivV.setAnimationListener(this.ivX);
    }

    public void xx(int i) {
        if (this.ivO != null) {
            this.ivO.xx(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fvE != null) {
            ao.setBackgroundResource(this.fvE, R.color.cp_bg_line_d);
        }
        if (this.ivS != null) {
            ao.setViewTextColor(this.ivS, R.color.cp_cont_d);
        }
        if (this.fVy != null) {
            ao.setImageResource(this.fVy, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ivO.setData(list);
    }

    public void cn(View view) {
        if (view != null) {
            this.ivO.notifyDataSetChanged();
            if (this.ivR == null) {
                this.ivR = new com.baidu.tieba.homepage.gamevideo.view.a(this.dVN, this.mRootView, -1, -1);
                this.ivR.setBackgroundDrawable(new ColorDrawable(this.dVN.getResources().getColor(R.color.black_alpha66)));
                this.ivR.setAnimationStyle(0);
                this.ivR.a(this.ivY);
                this.ivR.setFocusable(true);
                this.ivR.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ivR.isShowing()) {
                this.ivR.dismiss();
            }
            this.ivR.showAsDropDown(view, 0, 0);
            this.ivN.cmD();
            if (this.fvE != null && this.ivU != null) {
                this.fvE.startAnimation(this.ivU);
            }
            if (this.ivT != null) {
                this.ivT.cmv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        if (this.ivV != null && this.fvE != null && !this.ivW) {
            this.fvE.startAnimation(this.ivV);
        }
    }

    public void cms() {
        if (this.ivR != null) {
            this.ivR.dismiss();
        }
    }

    public void cmt() {
        if (this.ivR != null) {
            this.ivR.byi();
        }
    }

    public boolean isShowing() {
        if (this.ivR != null) {
            return this.ivR.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ivT = aVar;
    }

    public void onDestroy() {
        cmt();
        if (this.ivU != null) {
            this.ivU.cancel();
        }
        if (this.ivV != null) {
            this.ivV.cancel();
        }
        if (this.ivN != null) {
            this.ivN.onDestroy();
        }
    }
}

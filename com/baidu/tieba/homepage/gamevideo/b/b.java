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
    private GameVideoGridView ivP;
    private com.baidu.tieba.homepage.gamevideo.a.b ivQ;
    private com.baidu.tieba.homepage.gamevideo.view.a ivT;
    private TextView ivU;
    private a ivV;
    private TranslateAnimation ivW;
    private TranslateAnimation ivX;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean ivY = false;
    private Animation.AnimationListener ivZ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ivY = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ivY = false;
            b.this.cmt();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ivQ != null && i < b.this.ivQ.getCount() && b.this.ivQ.getItem(i) != null && (b.this.ivQ.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ivQ.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ivV != null) {
                        b.this.ivV.b(aVar);
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
            if (b.this.ivV != null) {
                b.this.ivV.cmw();
            }
        }
    };
    private a.InterfaceC0645a iwa = new a.InterfaceC0645a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
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
        this.ivU = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ivP = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ivP.setMaxHeight(l.getEquipmentWidth(this.dVN.getPageActivity()));
        this.ivP.setNumColumns(4);
        this.ivP.setEmptyView(this.fjP);
        this.ivQ = new com.baidu.tieba.homepage.gamevideo.a.b(this.dVN, 102, this.mBdUniqueId);
        this.ivP.setAdapter((ListAdapter) this.ivQ);
        this.ivP.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cmq();
        onChangeSkinType();
    }

    private void cmq() {
        this.ivW = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ivW.setDuration(300L);
        this.ivW.setFillAfter(true);
        this.ivW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ivX = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ivX.setDuration(200L);
        this.ivX.setFillAfter(true);
        this.ivX.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ivX.setAnimationListener(this.ivZ);
    }

    public void xx(int i) {
        if (this.ivQ != null) {
            this.ivQ.xx(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fvE != null) {
            ao.setBackgroundResource(this.fvE, R.color.cp_bg_line_d);
        }
        if (this.ivU != null) {
            ao.setViewTextColor(this.ivU, R.color.cp_cont_d);
        }
        if (this.fVy != null) {
            ao.setImageResource(this.fVy, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ivQ.setData(list);
    }

    public void cn(View view) {
        if (view != null) {
            this.ivQ.notifyDataSetChanged();
            if (this.ivT == null) {
                this.ivT = new com.baidu.tieba.homepage.gamevideo.view.a(this.dVN, this.mRootView, -1, -1);
                this.ivT.setBackgroundDrawable(new ColorDrawable(this.dVN.getResources().getColor(R.color.black_alpha66)));
                this.ivT.setAnimationStyle(0);
                this.ivT.a(this.iwa);
                this.ivT.setFocusable(true);
                this.ivT.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ivT.isShowing()) {
                this.ivT.dismiss();
            }
            this.ivT.showAsDropDown(view, 0, 0);
            this.ivP.cmD();
            if (this.fvE != null && this.ivW != null) {
                this.fvE.startAnimation(this.ivW);
            }
            if (this.ivV != null) {
                this.ivV.cmv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmr() {
        if (this.ivX != null && this.fvE != null && !this.ivY) {
            this.fvE.startAnimation(this.ivX);
        }
    }

    public void cms() {
        if (this.ivT != null) {
            this.ivT.dismiss();
        }
    }

    public void cmt() {
        if (this.ivT != null) {
            this.ivT.byi();
        }
    }

    public boolean isShowing() {
        if (this.ivT != null) {
            return this.ivT.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ivV = aVar;
    }

    public void onDestroy() {
        cmt();
        if (this.ivW != null) {
            this.ivW.cancel();
        }
        if (this.ivX != null) {
            this.ivX.cancel();
        }
        if (this.ivP != null) {
            this.ivP.onDestroy();
        }
    }
}

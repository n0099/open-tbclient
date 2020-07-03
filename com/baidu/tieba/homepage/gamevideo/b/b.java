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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private TbPageContext dPv;
    private ImageView fQf;
    private RelativeLayout feM;
    private RelativeLayout fqu;
    private GameVideoGridView ipJ;
    private com.baidu.tieba.homepage.gamevideo.a.b ipK;
    private com.baidu.tieba.homepage.gamevideo.view.a ipN;
    private TextView ipO;
    private a ipP;
    private TranslateAnimation ipQ;
    private TranslateAnimation ipR;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean ipS = false;
    private Animation.AnimationListener ipT = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ipS = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ipS = false;
            b.this.ciR();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ipK != null && i < b.this.ipK.getCount() && b.this.ipK.getItem(i) != null && (b.this.ipK.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ipK.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ipP != null) {
                        b.this.ipP.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aVP().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aVP().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.ciR();
                    TiebaStatic.log(new ao("c13489").ag("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.ciQ();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ipP != null) {
                b.this.ipP.ciU();
            }
        }
    };
    private a.InterfaceC0635a ipU = new a.InterfaceC0635a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0635a
        public void ciS() {
            b.this.ciP();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void ciT();

        void ciU();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.dPv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.dPv.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fqu = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.feM = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fQf = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ipO = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ipJ = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ipJ.setMaxHeight(l.getEquipmentWidth(this.dPv.getPageActivity()));
        this.ipJ.setNumColumns(4);
        this.ipJ.setEmptyView(this.feM);
        this.ipK = new com.baidu.tieba.homepage.gamevideo.a.b(this.dPv, 102, this.mBdUniqueId);
        this.ipJ.setAdapter((ListAdapter) this.ipK);
        this.ipJ.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        ciO();
        onChangeSkinType();
    }

    private void ciO() {
        this.ipQ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ipQ.setDuration(300L);
        this.ipQ.setFillAfter(true);
        this.ipQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ipR = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ipR.setDuration(200L);
        this.ipR.setFillAfter(true);
        this.ipR.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ipR.setAnimationListener(this.ipT);
    }

    public void xf(int i) {
        if (this.ipK != null) {
            this.ipK.xf(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fqu != null) {
            an.setBackgroundResource(this.fqu, R.color.cp_bg_line_d);
        }
        if (this.ipO != null) {
            an.setViewTextColor(this.ipO, (int) R.color.cp_cont_d);
        }
        if (this.fQf != null) {
            an.setImageResource(this.fQf, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ipK.setData(list);
    }

    public void ch(View view) {
        if (view != null) {
            this.ipK.notifyDataSetChanged();
            if (this.ipN == null) {
                this.ipN = new com.baidu.tieba.homepage.gamevideo.view.a(this.dPv, this.mRootView, -1, -1);
                this.ipN.setBackgroundDrawable(new ColorDrawable(this.dPv.getResources().getColor(R.color.black_alpha66)));
                this.ipN.setAnimationStyle(0);
                this.ipN.a(this.ipU);
                this.ipN.setFocusable(true);
                this.ipN.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ipN.isShowing()) {
                this.ipN.dismiss();
            }
            this.ipN.showAsDropDown(view, 0, 0);
            this.ipJ.cjb();
            if (this.fqu != null && this.ipQ != null) {
                this.fqu.startAnimation(this.ipQ);
            }
            if (this.ipP != null) {
                this.ipP.ciT();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciP() {
        if (this.ipR != null && this.fqu != null && !this.ipS) {
            this.fqu.startAnimation(this.ipR);
        }
    }

    public void ciQ() {
        if (this.ipN != null) {
            this.ipN.dismiss();
        }
    }

    public void ciR() {
        if (this.ipN != null) {
            this.ipN.buY();
        }
    }

    public boolean isShowing() {
        if (this.ipN != null) {
            return this.ipN.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ipP = aVar;
    }

    public void onDestroy() {
        ciR();
        if (this.ipQ != null) {
            this.ipQ.cancel();
        }
        if (this.ipR != null) {
            this.ipR.cancel();
        }
        if (this.ipJ != null) {
            this.ipJ.onDestroy();
        }
    }
}

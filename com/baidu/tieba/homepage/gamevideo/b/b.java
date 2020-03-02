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
    private TbPageContext cVh;
    private ImageView eLL;
    private RelativeLayout ehs;
    private RelativeLayout eok;
    private GameVideoGridView haI;
    private com.baidu.tieba.homepage.gamevideo.a.b haJ;
    private com.baidu.tieba.homepage.gamevideo.view.a haM;
    private TextView haN;
    private a haO;
    private TranslateAnimation haP;
    private TranslateAnimation haQ;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean haR = false;
    private Animation.AnimationListener haS = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.haR = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.haR = false;
            b.this.bOc();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.haJ != null && i < b.this.haJ.getCount() && b.this.haJ.getItem(i) != null && (b.this.haJ.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.haJ.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.haO != null) {
                        b.this.haO.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFD().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aFD().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bOc();
                    TiebaStatic.log(new an("c13489").X("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bOb();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.haO != null) {
                b.this.haO.bOf();
            }
        }
    };
    private a.InterfaceC0518a haT = new a.InterfaceC0518a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0518a
        public void bOd() {
            b.this.bOa();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bOe();

        void bOf();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVh = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cVh.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eok = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ehs = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eLL = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.haN = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.haI = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.haI.setMaxHeight(l.getEquipmentWidth(this.cVh.getPageActivity()));
        this.haI.setNumColumns(4);
        this.haI.setEmptyView(this.ehs);
        this.haJ = new com.baidu.tieba.homepage.gamevideo.a.b(this.cVh, 102, this.mBdUniqueId);
        this.haI.setAdapter((ListAdapter) this.haJ);
        this.haI.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bNZ();
        onChangeSkinType();
    }

    private void bNZ() {
        this.haP = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.haP.setDuration(300L);
        this.haP.setFillAfter(true);
        this.haP.setInterpolator(new AccelerateDecelerateInterpolator());
        this.haQ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.haQ.setDuration(200L);
        this.haQ.setFillAfter(true);
        this.haQ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.haQ.setAnimationListener(this.haS);
    }

    public void vm(int i) {
        if (this.haJ != null) {
            this.haJ.vm(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eok != null) {
            am.setBackgroundResource(this.eok, R.color.cp_bg_line_d);
        }
        if (this.haN != null) {
            am.setViewTextColor(this.haN, (int) R.color.cp_cont_d);
        }
        if (this.eLL != null) {
            am.setImageResource(this.eLL, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.haJ.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.haJ.notifyDataSetChanged();
            if (this.haM == null) {
                this.haM = new com.baidu.tieba.homepage.gamevideo.view.a(this.cVh, this.mRootView, -1, -1);
                this.haM.setBackgroundDrawable(new ColorDrawable(this.cVh.getResources().getColor(R.color.black_alpha66)));
                this.haM.setAnimationStyle(0);
                this.haM.a(this.haT);
                this.haM.setFocusable(true);
                this.haM.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.haM.isShowing()) {
                this.haM.dismiss();
            }
            this.haM.showAsDropDown(view, 0, 0);
            this.haI.bOm();
            if (this.eok != null && this.haP != null) {
                this.eok.startAnimation(this.haP);
            }
            if (this.haO != null) {
                this.haO.bOe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOa() {
        if (this.haQ != null && this.eok != null && !this.haR) {
            this.eok.startAnimation(this.haQ);
        }
    }

    public void bOb() {
        if (this.haM != null) {
            this.haM.dismiss();
        }
    }

    public void bOc() {
        if (this.haM != null) {
            this.haM.bdI();
        }
    }

    public boolean isShowing() {
        if (this.haM != null) {
            return this.haM.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.haO = aVar;
    }

    public void onDestroy() {
        bOc();
        if (this.haP != null) {
            this.haP.cancel();
        }
        if (this.haQ != null) {
            this.haQ.cancel();
        }
        if (this.haI != null) {
            this.haI.onDestroy();
        }
    }
}

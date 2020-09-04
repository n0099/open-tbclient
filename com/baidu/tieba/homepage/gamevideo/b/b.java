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
/* loaded from: classes16.dex */
public class b {
    private TbPageContext efr;
    private RelativeLayout fHa;
    private RelativeLayout fvp;
    private ImageView ghB;
    private GameVideoGridView iKk;
    private com.baidu.tieba.homepage.gamevideo.a.b iKl;
    private com.baidu.tieba.homepage.gamevideo.view.a iKo;
    private TextView iKp;
    private a iKq;
    private TranslateAnimation iKr;
    private TranslateAnimation iKs;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean iKt = false;
    private Animation.AnimationListener iKu = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.iKt = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.iKt = false;
            b.this.cxd();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.iKl != null && i < b.this.iKl.getCount() && b.this.iKl.getItem(i) != null && (b.this.iKl.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.iKl.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.iKq != null) {
                        b.this.iKq.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cxd();
                    TiebaStatic.log(new aq("c13489").ai("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cxc();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.iKq != null) {
                b.this.iKq.cxg();
            }
        }
    };
    private a.InterfaceC0696a iKv = new a.InterfaceC0696a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0696a
        public void cxe() {
            b.this.cxb();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cxf();

        void cxg();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efr = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.efr.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fHa = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fvp = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.ghB = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.iKp = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.iKk = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.iKk.setMaxHeight(l.getEquipmentWidth(this.efr.getPageActivity()));
        this.iKk.setNumColumns(4);
        this.iKk.setEmptyView(this.fvp);
        this.iKl = new com.baidu.tieba.homepage.gamevideo.a.b(this.efr, 102, this.mBdUniqueId);
        this.iKk.setAdapter((ListAdapter) this.iKl);
        this.iKk.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cxa();
        onChangeSkinType();
    }

    private void cxa() {
        this.iKr = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.iKr.setDuration(300L);
        this.iKr.setFillAfter(true);
        this.iKr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iKs = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.iKs.setDuration(200L);
        this.iKs.setFillAfter(true);
        this.iKs.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iKs.setAnimationListener(this.iKu);
    }

    public void zR(int i) {
        if (this.iKl != null) {
            this.iKl.zR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fHa != null) {
            ap.setBackgroundResource(this.fHa, R.color.cp_bg_line_d);
        }
        if (this.iKp != null) {
            ap.setViewTextColor(this.iKp, R.color.cp_cont_d);
        }
        if (this.ghB != null) {
            ap.setImageResource(this.ghB, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.iKl.setData(list);
    }

    public void cp(View view) {
        if (view != null) {
            this.iKl.notifyDataSetChanged();
            if (this.iKo == null) {
                this.iKo = new com.baidu.tieba.homepage.gamevideo.view.a(this.efr, this.mRootView, -1, -1);
                this.iKo.setBackgroundDrawable(new ColorDrawable(this.efr.getResources().getColor(R.color.black_alpha66)));
                this.iKo.setAnimationStyle(0);
                this.iKo.a(this.iKv);
                this.iKo.setFocusable(true);
                this.iKo.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.iKo.isShowing()) {
                this.iKo.dismiss();
            }
            this.iKo.showAsDropDown(view, 0, 0);
            this.iKk.cxn();
            if (this.fHa != null && this.iKr != null) {
                this.fHa.startAnimation(this.iKr);
            }
            if (this.iKq != null) {
                this.iKq.cxf();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxb() {
        if (this.iKs != null && this.fHa != null && !this.iKt) {
            this.fHa.startAnimation(this.iKs);
        }
    }

    public void cxc() {
        if (this.iKo != null) {
            this.iKo.dismiss();
        }
    }

    public void cxd() {
        if (this.iKo != null) {
            this.iKo.bHj();
        }
    }

    public boolean isShowing() {
        if (this.iKo != null) {
            return this.iKo.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.iKq = aVar;
    }

    public void onDestroy() {
        cxd();
        if (this.iKr != null) {
            this.iKr.cancel();
        }
        if (this.iKs != null) {
            this.iKs.cancel();
        }
        if (this.iKk != null) {
            this.iKk.onDestroy();
        }
    }
}

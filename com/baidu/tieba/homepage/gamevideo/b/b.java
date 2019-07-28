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
/* loaded from: classes4.dex */
public class b {
    private RelativeLayout dpX;
    private com.baidu.tieba.homepage.gamevideo.a.b ggA;
    private com.baidu.tieba.homepage.gamevideo.view.a ggD;
    private RelativeLayout ggE;
    private ImageView ggF;
    private TextView ggG;
    private a ggH;
    private TranslateAnimation ggI;
    private TranslateAnimation ggJ;
    private GameVideoGridView ggz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private View mRootView;
    private boolean ggK = false;
    private Animation.AnimationListener ggL = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ggK = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ggK = false;
            b.this.bvX();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ggA != null && i < b.this.ggA.getCount() && b.this.ggA.getItem(i) != null && (b.this.ggA.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ggA.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ggH != null) {
                        b.this.ggH.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahO().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.ahO().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bvX();
                    TiebaStatic.log(new an("c13489").P("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bvW();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ggH != null) {
                b.this.ggH.bwa();
            }
        }
    };
    private a.InterfaceC0326a ggM = new a.InterfaceC0326a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0326a
        public void bvY() {
            b.this.bvV();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bvZ();

        void bwa();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.dpX = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ggE = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.ggF = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ggG = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ggz = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ggz.setMaxHeight(l.af(this.mContext.getPageActivity()));
        this.ggz.setNumColumns(4);
        this.ggz.setEmptyView(this.ggE);
        this.ggA = new com.baidu.tieba.homepage.gamevideo.a.b(this.mContext, 102, this.mBdUniqueId);
        this.ggz.setAdapter((ListAdapter) this.ggA);
        this.ggz.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bvU();
        onChangeSkinType();
    }

    private void bvU() {
        this.ggI = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ggI.setDuration(300L);
        this.ggI.setFillAfter(true);
        this.ggI.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ggJ = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ggJ.setDuration(200L);
        this.ggJ.setFillAfter(true);
        this.ggJ.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ggJ.setAnimationListener(this.ggL);
    }

    public void tY(int i) {
        if (this.ggA != null) {
            this.ggA.tY(i);
        }
    }

    public void onChangeSkinType() {
        if (this.dpX != null) {
            am.k(this.dpX, R.color.cp_bg_line_d);
        }
        if (this.ggG != null) {
            am.j(this.ggG, R.color.cp_cont_d);
        }
        if (this.ggF != null) {
            am.c(this.ggF, (int) R.drawable.new_pic_emotion_gray_09);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ggA.setData(list);
    }

    public void ca(View view) {
        if (view != null) {
            this.ggA.notifyDataSetChanged();
            if (this.ggD == null) {
                this.ggD = new com.baidu.tieba.homepage.gamevideo.view.a(this.mContext, this.mRootView, -1, -1);
                this.ggD.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(R.color.black_alpha66)));
                this.ggD.setAnimationStyle(0);
                this.ggD.a(this.ggM);
                this.ggD.setFocusable(true);
                this.ggD.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ggD.isShowing()) {
                this.ggD.dismiss();
            }
            this.ggD.showAsDropDown(view, 0, 0);
            this.ggz.bwi();
            if (this.dpX != null && this.ggI != null) {
                this.dpX.startAnimation(this.ggI);
            }
            if (this.ggH != null) {
                this.ggH.bvZ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvV() {
        if (this.ggJ != null && this.dpX != null && !this.ggK) {
            this.dpX.startAnimation(this.ggJ);
        }
    }

    public void bvW() {
        if (this.ggD != null) {
            this.ggD.dismiss();
        }
    }

    public void bvX() {
        if (this.ggD != null) {
            this.ggD.bwh();
        }
    }

    public boolean isShowing() {
        if (this.ggD != null) {
            return this.ggD.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ggH = aVar;
    }

    public void onDestroy() {
        bvX();
        if (this.ggI != null) {
            this.ggI.cancel();
        }
        if (this.ggJ != null) {
            this.ggJ.cancel();
        }
        if (this.ggz != null) {
            this.ggz.onDestroy();
        }
    }
}

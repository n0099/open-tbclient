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
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eUY;
    private RelativeLayout gDq;
    private RelativeLayout gpk;
    private ImageView hkX;
    private GameVideoGridView keT;
    private com.baidu.tieba.homepage.gamevideo.a.b keU;
    private com.baidu.tieba.homepage.gamevideo.view.a keX;
    private TextView keY;
    private a keZ;
    private TranslateAnimation kfa;
    private TranslateAnimation kfb;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean kfc = false;
    private Animation.AnimationListener kfd = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.kfc = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.kfc = false;
            b.this.cQh();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.keU != null && i < b.this.keU.getCount() && b.this.keU.getItem(i) != null && (b.this.keU.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.keU.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.keZ != null) {
                        b.this.keZ.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cQh();
                    TiebaStatic.log(new ar("c13489").ap("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cQg();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.keZ != null) {
                b.this.keZ.cQk();
            }
        }
    };
    private a.InterfaceC0745a kfe = new a.InterfaceC0745a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0745a
        public void cQi() {
            b.this.cQf();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cQj();

        void cQk();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gDq = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.gpk = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.hkX = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.keY = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.keT = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.keT.setMaxHeight(l.getEquipmentWidth(this.eUY.getPageActivity()));
        this.keT.setNumColumns(4);
        this.keT.setEmptyView(this.gpk);
        this.keU = new com.baidu.tieba.homepage.gamevideo.a.b(this.eUY, 102, this.mBdUniqueId);
        this.keT.setAdapter((ListAdapter) this.keU);
        this.keT.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cQe();
        onChangeSkinType();
    }

    private void cQe() {
        this.kfa = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.kfa.setDuration(300L);
        this.kfa.setFillAfter(true);
        this.kfa.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kfb = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.kfb.setDuration(200L);
        this.kfb.setFillAfter(true);
        this.kfb.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kfb.setAnimationListener(this.kfd);
    }

    public void BO(int i) {
        if (this.keU != null) {
            this.keU.BO(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gDq != null) {
            ap.setBackgroundResource(this.gDq, R.color.CAM_X0201);
        }
        if (this.keY != null) {
            ap.setViewTextColor(this.keY, R.color.CAM_X0109);
        }
        if (this.hkX != null) {
            ap.setImageResource(this.hkX, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.keU.setData(list);
    }

    public void de(View view) {
        if (view != null) {
            this.keU.notifyDataSetChanged();
            if (this.keX == null) {
                this.keX = new com.baidu.tieba.homepage.gamevideo.view.a(this.eUY, this.mRootView, -1, -1);
                this.keX.setBackgroundDrawable(new ColorDrawable(this.eUY.getResources().getColor(R.color.black_alpha66)));
                this.keX.setAnimationStyle(0);
                this.keX.a(this.kfe);
                this.keX.setFocusable(true);
                this.keX.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.keX.isShowing()) {
                this.keX.dismiss();
            }
            this.keX.showAsDropDown(view, 0, 0);
            this.keT.cQr();
            if (this.gDq != null && this.kfa != null) {
                this.gDq.startAnimation(this.kfa);
            }
            if (this.keZ != null) {
                this.keZ.cQj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQf() {
        if (this.kfb != null && this.gDq != null && !this.kfc) {
            this.gDq.startAnimation(this.kfb);
        }
    }

    public void cQg() {
        if (this.keX != null) {
            this.keX.dismiss();
        }
    }

    public void cQh() {
        if (this.keX != null) {
            this.keX.Yc();
        }
    }

    public boolean isShowing() {
        if (this.keX != null) {
            return this.keX.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.keZ = aVar;
    }

    public void onDestroy() {
        cQh();
        if (this.kfa != null) {
            this.kfa.cancel();
        }
        if (this.kfb != null) {
            this.kfb.cancel();
        }
        if (this.keT != null) {
            this.keT.onDestroy();
        }
    }
}

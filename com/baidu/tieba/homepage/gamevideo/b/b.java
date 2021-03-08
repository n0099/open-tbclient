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
    private TbPageContext eWx;
    private RelativeLayout gFn;
    private RelativeLayout grh;
    private ImageView hmU;
    private GameVideoGridView khj;
    private com.baidu.tieba.homepage.gamevideo.a.b khk;
    private com.baidu.tieba.homepage.gamevideo.view.a khn;
    private TextView kho;
    private a khp;
    private TranslateAnimation khq;
    private TranslateAnimation khr;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean khs = false;
    private Animation.AnimationListener kht = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.khs = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.khs = false;
            b.this.cQv();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.khk != null && i < b.this.khk.getCount() && b.this.khk.getItem(i) != null && (b.this.khk.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.khk.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.khp != null) {
                        b.this.khp.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.brR().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brR().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cQv();
                    TiebaStatic.log(new ar("c13489").aq("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cQu();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.khp != null) {
                b.this.khp.cQy();
            }
        }
    };
    private a.InterfaceC0752a khu = new a.InterfaceC0752a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0752a
        public void cQw() {
            b.this.cQt();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cQx();

        void cQy();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eWx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gFn = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.grh = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.hmU = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.kho = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.khj = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.khj.setMaxHeight(l.getEquipmentWidth(this.eWx.getPageActivity()));
        this.khj.setNumColumns(4);
        this.khj.setEmptyView(this.grh);
        this.khk = new com.baidu.tieba.homepage.gamevideo.a.b(this.eWx, 102, this.mBdUniqueId);
        this.khj.setAdapter((ListAdapter) this.khk);
        this.khj.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cQs();
        onChangeSkinType();
    }

    private void cQs() {
        this.khq = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.khq.setDuration(300L);
        this.khq.setFillAfter(true);
        this.khq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.khr = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.khr.setDuration(200L);
        this.khr.setFillAfter(true);
        this.khr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.khr.setAnimationListener(this.kht);
    }

    public void BR(int i) {
        if (this.khk != null) {
            this.khk.BR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gFn != null) {
            ap.setBackgroundResource(this.gFn, R.color.CAM_X0201);
        }
        if (this.kho != null) {
            ap.setViewTextColor(this.kho, R.color.CAM_X0109);
        }
        if (this.hmU != null) {
            ap.setImageResource(this.hmU, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.khk.setData(list);
    }

    public void de(View view) {
        if (view != null) {
            this.khk.notifyDataSetChanged();
            if (this.khn == null) {
                this.khn = new com.baidu.tieba.homepage.gamevideo.view.a(this.eWx, this.mRootView, -1, -1);
                this.khn.setBackgroundDrawable(new ColorDrawable(this.eWx.getResources().getColor(R.color.black_alpha66)));
                this.khn.setAnimationStyle(0);
                this.khn.a(this.khu);
                this.khn.setFocusable(true);
                this.khn.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.khn.isShowing()) {
                this.khn.dismiss();
            }
            this.khn.showAsDropDown(view, 0, 0);
            this.khj.cQF();
            if (this.gFn != null && this.khq != null) {
                this.gFn.startAnimation(this.khq);
            }
            if (this.khp != null) {
                this.khp.cQx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQt() {
        if (this.khr != null && this.gFn != null && !this.khs) {
            this.gFn.startAnimation(this.khr);
        }
    }

    public void cQu() {
        if (this.khn != null) {
            this.khn.dismiss();
        }
    }

    public void cQv() {
        if (this.khn != null) {
            this.khn.Yf();
        }
    }

    public boolean isShowing() {
        if (this.khn != null) {
            return this.khn.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.khp = aVar;
    }

    public void onDestroy() {
        cQv();
        if (this.khq != null) {
            this.khq.cancel();
        }
        if (this.khr != null) {
            this.khr.cancel();
        }
        if (this.khj != null) {
            this.khj.onDestroy();
        }
    }
}

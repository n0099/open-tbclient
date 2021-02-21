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
    private RelativeLayout gDE;
    private RelativeLayout gpy;
    private ImageView hll;
    private GameVideoGridView kfh;
    private com.baidu.tieba.homepage.gamevideo.a.b kfi;
    private com.baidu.tieba.homepage.gamevideo.view.a kfl;
    private TextView kfm;
    private a kfn;
    private TranslateAnimation kfo;
    private TranslateAnimation kfp;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean kfq = false;
    private Animation.AnimationListener kfr = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.kfq = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.kfq = false;
            b.this.cQo();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.kfi != null && i < b.this.kfi.getCount() && b.this.kfi.getItem(i) != null && (b.this.kfi.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.kfi.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.kfn != null) {
                        b.this.kfn.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cQo();
                    TiebaStatic.log(new ar("c13489").ap("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cQn();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.kfn != null) {
                b.this.kfn.cQr();
            }
        }
    };
    private a.InterfaceC0746a kfs = new a.InterfaceC0746a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0746a
        public void cQp() {
            b.this.cQm();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cQq();

        void cQr();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gDE = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.gpy = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.hll = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.kfm = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.kfh = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.kfh.setMaxHeight(l.getEquipmentWidth(this.eUY.getPageActivity()));
        this.kfh.setNumColumns(4);
        this.kfh.setEmptyView(this.gpy);
        this.kfi = new com.baidu.tieba.homepage.gamevideo.a.b(this.eUY, 102, this.mBdUniqueId);
        this.kfh.setAdapter((ListAdapter) this.kfi);
        this.kfh.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cQl();
        onChangeSkinType();
    }

    private void cQl() {
        this.kfo = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.kfo.setDuration(300L);
        this.kfo.setFillAfter(true);
        this.kfo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kfp = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.kfp.setDuration(200L);
        this.kfp.setFillAfter(true);
        this.kfp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kfp.setAnimationListener(this.kfr);
    }

    public void BO(int i) {
        if (this.kfi != null) {
            this.kfi.BO(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gDE != null) {
            ap.setBackgroundResource(this.gDE, R.color.CAM_X0201);
        }
        if (this.kfm != null) {
            ap.setViewTextColor(this.kfm, R.color.CAM_X0109);
        }
        if (this.hll != null) {
            ap.setImageResource(this.hll, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.kfi.setData(list);
    }

    public void de(View view) {
        if (view != null) {
            this.kfi.notifyDataSetChanged();
            if (this.kfl == null) {
                this.kfl = new com.baidu.tieba.homepage.gamevideo.view.a(this.eUY, this.mRootView, -1, -1);
                this.kfl.setBackgroundDrawable(new ColorDrawable(this.eUY.getResources().getColor(R.color.black_alpha66)));
                this.kfl.setAnimationStyle(0);
                this.kfl.a(this.kfs);
                this.kfl.setFocusable(true);
                this.kfl.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.kfl.isShowing()) {
                this.kfl.dismiss();
            }
            this.kfl.showAsDropDown(view, 0, 0);
            this.kfh.cQy();
            if (this.gDE != null && this.kfo != null) {
                this.gDE.startAnimation(this.kfo);
            }
            if (this.kfn != null) {
                this.kfn.cQq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQm() {
        if (this.kfp != null && this.gDE != null && !this.kfq) {
            this.gDE.startAnimation(this.kfp);
        }
    }

    public void cQn() {
        if (this.kfl != null) {
            this.kfl.dismiss();
        }
    }

    public void cQo() {
        if (this.kfl != null) {
            this.kfl.Yc();
        }
    }

    public boolean isShowing() {
        if (this.kfl != null) {
            return this.kfl.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.kfn = aVar;
    }

    public void onDestroy() {
        cQo();
        if (this.kfo != null) {
            this.kfo.cancel();
        }
        if (this.kfp != null) {
            this.kfp.cancel();
        }
        if (this.kfh != null) {
            this.kfh.onDestroy();
        }
    }
}

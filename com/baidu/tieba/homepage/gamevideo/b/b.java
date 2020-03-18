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
    private TbPageContext cVv;
    private ImageView eMu;
    private RelativeLayout ehV;
    private RelativeLayout eoO;
    private GameVideoGridView hcc;
    private com.baidu.tieba.homepage.gamevideo.a.b hcd;
    private com.baidu.tieba.homepage.gamevideo.view.a hcg;
    private TextView hch;
    private a hci;
    private TranslateAnimation hcj;
    private TranslateAnimation hck;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean hcl = false;
    private Animation.AnimationListener hcm = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.hcl = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.hcl = false;
            b.this.bOr();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.hcd != null && i < b.this.hcd.getCount() && b.this.hcd.getItem(i) != null && (b.this.hcd.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.hcd.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.hci != null) {
                        b.this.hci.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aFH().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aFH().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bOr();
                    TiebaStatic.log(new an("c13489").X("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bOq();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.hci != null) {
                b.this.hci.bOu();
            }
        }
    };
    private a.InterfaceC0518a hcn = new a.InterfaceC0518a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0518a
        public void bOs() {
            b.this.bOp();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bOt();

        void bOu();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.cVv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.cVv.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eoO = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ehV = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.eMu = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.hch = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.hcc = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.hcc.setMaxHeight(l.getEquipmentWidth(this.cVv.getPageActivity()));
        this.hcc.setNumColumns(4);
        this.hcc.setEmptyView(this.ehV);
        this.hcd = new com.baidu.tieba.homepage.gamevideo.a.b(this.cVv, 102, this.mBdUniqueId);
        this.hcc.setAdapter((ListAdapter) this.hcd);
        this.hcc.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bOo();
        onChangeSkinType();
    }

    private void bOo() {
        this.hcj = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.hcj.setDuration(300L);
        this.hcj.setFillAfter(true);
        this.hcj.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hck = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.hck.setDuration(200L);
        this.hck.setFillAfter(true);
        this.hck.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hck.setAnimationListener(this.hcm);
    }

    public void vt(int i) {
        if (this.hcd != null) {
            this.hcd.vt(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eoO != null) {
            am.setBackgroundResource(this.eoO, R.color.cp_bg_line_d);
        }
        if (this.hch != null) {
            am.setViewTextColor(this.hch, (int) R.color.cp_cont_d);
        }
        if (this.eMu != null) {
            am.setImageResource(this.eMu, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.hcd.setData(list);
    }

    public void bY(View view) {
        if (view != null) {
            this.hcd.notifyDataSetChanged();
            if (this.hcg == null) {
                this.hcg = new com.baidu.tieba.homepage.gamevideo.view.a(this.cVv, this.mRootView, -1, -1);
                this.hcg.setBackgroundDrawable(new ColorDrawable(this.cVv.getResources().getColor(R.color.black_alpha66)));
                this.hcg.setAnimationStyle(0);
                this.hcg.a(this.hcn);
                this.hcg.setFocusable(true);
                this.hcg.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.hcg.isShowing()) {
                this.hcg.dismiss();
            }
            this.hcg.showAsDropDown(view, 0, 0);
            this.hcc.bOB();
            if (this.eoO != null && this.hcj != null) {
                this.eoO.startAnimation(this.hcj);
            }
            if (this.hci != null) {
                this.hci.bOt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOp() {
        if (this.hck != null && this.eoO != null && !this.hcl) {
            this.eoO.startAnimation(this.hck);
        }
    }

    public void bOq() {
        if (this.hcg != null) {
            this.hcg.dismiss();
        }
    }

    public void bOr() {
        if (this.hcg != null) {
            this.hcg.bdO();
        }
    }

    public boolean isShowing() {
        if (this.hcg != null) {
            return this.hcg.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.hci = aVar;
    }

    public void onDestroy() {
        bOr();
        if (this.hcj != null) {
            this.hcj.cancel();
        }
        if (this.hck != null) {
            this.hck.cancel();
        }
        if (this.hcc != null) {
            this.hcc.onDestroy();
        }
    }
}

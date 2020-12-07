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
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eNx;
    private ImageView gZx;
    private RelativeLayout ggI;
    private RelativeLayout gul;
    private GameVideoGridView jOG;
    private com.baidu.tieba.homepage.gamevideo.a.b jOH;
    private com.baidu.tieba.homepage.gamevideo.view.a jOK;
    private TextView jOL;
    private a jOM;
    private TranslateAnimation jON;
    private TranslateAnimation jOO;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jOP = false;
    private Animation.AnimationListener jOQ = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jOP = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jOP = false;
            b.this.cOU();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jOH != null && i < b.this.jOH.getCount() && b.this.jOH.getItem(i) != null && (b.this.jOH.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jOH.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jOM != null) {
                        b.this.jOM.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cOU();
                    TiebaStatic.log(new ar("c13489").al("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cOT();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jOM != null) {
                b.this.jOM.cOX();
            }
        }
    };
    private a.InterfaceC0760a jOR = new a.InterfaceC0760a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0760a
        public void cOV() {
            b.this.cOS();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cOW();

        void cOX();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eNx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eNx.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gul = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ggI = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gZx = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jOL = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jOG = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jOG.setMaxHeight(l.getEquipmentWidth(this.eNx.getPageActivity()));
        this.jOG.setNumColumns(4);
        this.jOG.setEmptyView(this.ggI);
        this.jOH = new com.baidu.tieba.homepage.gamevideo.a.b(this.eNx, 102, this.mBdUniqueId);
        this.jOG.setAdapter((ListAdapter) this.jOH);
        this.jOG.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cOR();
        onChangeSkinType();
    }

    private void cOR() {
        this.jON = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jON.setDuration(300L);
        this.jON.setFillAfter(true);
        this.jON.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jOO = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jOO.setDuration(200L);
        this.jOO.setFillAfter(true);
        this.jOO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jOO.setAnimationListener(this.jOQ);
    }

    public void CR(int i) {
        if (this.jOH != null) {
            this.jOH.CR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gul != null) {
            ap.setBackgroundResource(this.gul, R.color.CAM_X0201);
        }
        if (this.jOL != null) {
            ap.setViewTextColor(this.jOL, R.color.CAM_X0109);
        }
        if (this.gZx != null) {
            ap.setImageResource(this.gZx, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jOH.setData(list);
    }

    public void cW(View view) {
        if (view != null) {
            this.jOH.notifyDataSetChanged();
            if (this.jOK == null) {
                this.jOK = new com.baidu.tieba.homepage.gamevideo.view.a(this.eNx, this.mRootView, -1, -1);
                this.jOK.setBackgroundDrawable(new ColorDrawable(this.eNx.getResources().getColor(R.color.black_alpha66)));
                this.jOK.setAnimationStyle(0);
                this.jOK.a(this.jOR);
                this.jOK.setFocusable(true);
                this.jOK.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jOK.isShowing()) {
                this.jOK.dismiss();
            }
            this.jOK.showAsDropDown(view, 0, 0);
            this.jOG.cPe();
            if (this.gul != null && this.jON != null) {
                this.gul.startAnimation(this.jON);
            }
            if (this.jOM != null) {
                this.jOM.cOW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOS() {
        if (this.jOO != null && this.gul != null && !this.jOP) {
            this.gul.startAnimation(this.jOO);
        }
    }

    public void cOT() {
        if (this.jOK != null) {
            this.jOK.dismiss();
        }
    }

    public void cOU() {
        if (this.jOK != null) {
            this.jOK.YQ();
        }
    }

    public boolean isShowing() {
        if (this.jOK != null) {
            return this.jOK.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jOM = aVar;
    }

    public void onDestroy() {
        cOU();
        if (this.jON != null) {
            this.jON.cancel();
        }
        if (this.jOO != null) {
            this.jOO.cancel();
        }
        if (this.jOG != null) {
            this.jOG.onDestroy();
        }
    }
}

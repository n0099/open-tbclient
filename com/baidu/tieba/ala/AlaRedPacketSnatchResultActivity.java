package com.baidu.tieba.ala;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.ad;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.i;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.g.o;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private FrameLayout bVn;
    private HeadImageView bck;
    private String bhk;
    private TextView dWe;
    private View fxA;
    private LinearLayout fxB;
    private TextView fzf;
    private TextView fzg;
    private TextView fzh;
    private BdListView fzi;
    private a fzj;
    private com.baidu.tieba.ala.data.e fzk;
    private com.baidu.tieba.ala.g.g fzl;
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;
    private CustomMessageListener azu = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private o fzm = new o() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.g.o
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.g.o
        public void az(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_red_packet_snatch_result_view);
            initView();
            this.fzl = new com.baidu.tieba.ala.g.g(getPageContext(), this.fzm);
            this.fzl.aj(this.mRedPacketId, this.mLiveId, this.bhk);
            MessageManager.getInstance().registerListener(this.azu);
            kv(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bhk = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fxA = findViewById(a.g.rp_result_root_bg);
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_result_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaRedPacketSnatchResultActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.bVn = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.bck = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.bck.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.bck.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.bck.setIsRound(true);
        this.bck.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bck.setAutoChangeStyle(true);
        this.bck.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzf = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dWe = (TextView) findViewById(a.g.p_result_user_name);
        this.fzg = (TextView) findViewById(a.g.p_result_loot_amount);
        this.fxB = (LinearLayout) findViewById(a.g.rp_result_content);
        this.fzh = (TextView) findViewById(a.g.p_result_send_gift);
        this.fzi = (BdListView) findViewById(a.g.p_result_listview);
        this.fzh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bFd();
            }
        });
        this.fxB.setVisibility(8);
        this.fzh.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFd() {
        ad adVar = new ad();
        adVar.aFM = -1;
        adVar.aFN = -1;
        adVar.aFP = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.fzk = eVar;
        this.fxB.setVisibility(0);
        this.fzh.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            l.a(this.bck, eVar.portrait, true, false);
        }
        this.dWe.setText(eVar.userName);
        if (eVar.fXT) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(eVar.fXB));
            this.fzh.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fxB.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.fxB.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.fzh.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fxB.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.fxB.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fzg.setText(str);
        W(eVar.fXU);
    }

    private void W(ArrayList<e.a> arrayList) {
        this.fzj = new a(getPageContext().getPageActivity(), arrayList);
        this.fzi.setAdapter((ListAdapter) this.fzj);
        this.fzj.notifyDataSetChanged();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        kv(configuration.orientation == 2);
    }

    private void kv(boolean z) {
        if (z) {
            i.aa(this.bVn);
            this.bVn.setScaleX(0.85f);
            this.bVn.setScaleY(0.85f);
            return;
        }
        i.ab(this.bVn);
        this.bVn.setScaleX(1.0f);
        this.bVn.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fzl != null) {
            this.fzl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.azu);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> fzo;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.fzo = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fzo != null) {
                return this.fzo.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: sF */
        public e.a getItem(int i) {
            if (this.fzo != null) {
                return this.fzo.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.mContext).inflate(a.h.ala_loot_user_item, viewGroup, false);
                bVar2.bbk = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.bbk.setIsRound(true);
                bVar2.bbk.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.bbk.setAutoChangeStyle(true);
                bVar2.bbk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fzp = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.fzq = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    l.a(bVar.bbk, item.portrait, true, false);
                }
                bVar.fzp.setText(item.userName);
                bVar.fzq.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fXV)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView bbk;
        public TextView fzp;
        public TextView fzq;

        private b() {
        }
    }
}

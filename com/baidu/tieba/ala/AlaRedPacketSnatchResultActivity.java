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
import com.baidu.live.data.v;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.data.d;
import com.baidu.tieba.ala.f.k;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView aQx;
    private String aWr;
    private FrameLayout bIi;
    private TextView dXU;
    private View eTL;
    private LinearLayout eTM;
    private TextView eVg;
    private TextView eVh;
    private TextView eVi;
    private BdListView eVj;
    private a eVk;
    private com.baidu.tieba.ala.data.d eVl;
    private com.baidu.tieba.ala.f.e eVm;
    private CustomMessageListener eVn = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private k eVo = new k() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.k
        public void b(com.baidu.tieba.ala.data.d dVar) {
            AlaRedPacketSnatchResultActivity.this.a(dVar);
        }

        @Override // com.baidu.tieba.ala.f.k
        public void ax(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private ImageView mCloseBtn;
    private String mLiveId;
    private String mRedPacketId;

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
            this.eVm = new com.baidu.tieba.ala.f.e(getPageContext(), this.eVo);
            this.eVm.ah(this.mRedPacketId, this.mLiveId, this.aWr);
            MessageManager.getInstance().registerListener(this.eVn);
            je(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aWr = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eTL = findViewById(a.g.rp_result_root_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.bIi = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aQx = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aQx.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aQx.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aQx.setIsRound(true);
        this.aQx.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aQx.setAutoChangeStyle(true);
        this.aQx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVg = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dXU = (TextView) findViewById(a.g.p_result_user_name);
        this.eVh = (TextView) findViewById(a.g.p_result_loot_amount);
        this.eTM = (LinearLayout) findViewById(a.g.rp_result_content);
        this.eVi = (TextView) findViewById(a.g.p_result_send_gift);
        this.eVj = (BdListView) findViewById(a.g.p_result_listview);
        this.eVi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.bpj();
            }
        });
        this.eTM.setVisibility(8);
        this.eVi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        v vVar = new v();
        vVar.avT = -1;
        vVar.avU = -1;
        vVar.avW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, vVar));
    }

    public void a(com.baidu.tieba.ala.data.d dVar) {
        String str;
        this.eVl = dVar;
        this.eTM.setVisibility(0);
        this.eVi.setVisibility(0);
        if (!StringUtils.isNullObject(dVar.portrait)) {
            com.baidu.live.utils.k.a(this.aQx, dVar.portrait, true, false);
        }
        this.dXU.setText(dVar.userName);
        if (dVar.fsD) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(dVar.fsl));
            this.eVi.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTM.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.eTM.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.eVi.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eTM.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.eTM.setLayoutParams(layoutParams2);
            str = string;
        }
        this.eVh.setText(str);
        P(dVar.fsE);
    }

    private void P(ArrayList<d.a> arrayList) {
        this.eVk = new a(getPageContext().getPageActivity(), arrayList);
        this.eVj.setAdapter((ListAdapter) this.eVk);
        this.eVk.notifyDataSetChanged();
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
        je(configuration.orientation == 2);
    }

    private void je(boolean z) {
        if (z) {
            h.T(this.bIi);
            this.bIi.setScaleX(0.85f);
            this.bIi.setScaleY(0.85f);
            return;
        }
        h.U(this.bIi);
        this.bIi.setScaleX(1.0f);
        this.bIi.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eVm != null) {
            this.eVm.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eVn);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BaseAdapter {
        private ArrayList<d.a> eVq;
        private Context mContext;

        public a(Context context, ArrayList<d.a> arrayList) {
            this.mContext = context;
            this.eVq = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.eVq != null) {
                return this.eVq.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: pq */
        public d.a getItem(int i) {
            if (this.eVq != null) {
                return this.eVq.get(i);
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
                bVar2.aPy = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.aPy.setIsRound(true);
                bVar2.aPy.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.aPy.setAutoChangeStyle(true);
                bVar2.aPy.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.eVr = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.eVs = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            d.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    com.baidu.live.utils.k.a(bVar.aPy, item.portrait, true, false);
                }
                bVar.eVr.setText(item.userName);
                bVar.eVs.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fsF)));
            }
            return view;
        }
    }

    /* loaded from: classes3.dex */
    private static class b {
        public HeadImageView aPy;
        public TextView eVr;
        public TextView eVs;

        private b() {
        }
    }
}

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
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.e;
import com.baidu.tieba.ala.f.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AlaRedPacketSnatchResultActivity extends BaseFragmentActivity {
    private HeadImageView aUw;
    private String aYY;
    private FrameLayout bNL;
    private TextView dKI;
    private View fiP;
    private LinearLayout fiQ;
    private com.baidu.tieba.ala.f.f fkA;
    private CustomMessageListener fkB = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaRedPacketSnatchResultActivity.this.finish();
        }
    };
    private l fkC = new l() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.2
        @Override // com.baidu.tieba.ala.f.l
        public void b(com.baidu.tieba.ala.data.e eVar) {
            AlaRedPacketSnatchResultActivity.this.a(eVar);
        }

        @Override // com.baidu.tieba.ala.f.l
        public void aB(int i, String str) {
            AlaRedPacketSnatchResultActivity.this.showToast(a.i.sdk_net_fail_tip);
        }
    };
    private TextView fku;
    private TextView fkv;
    private TextView fkw;
    private BdListView fkx;
    private a fky;
    private com.baidu.tieba.ala.data.e fkz;
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
            this.fkA = new com.baidu.tieba.ala.f.f(getPageContext(), this.fkC);
            this.fkA.aj(this.mRedPacketId, this.mLiveId, this.aYY);
            MessageManager.getInstance().registerListener(this.fkB);
            jU(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aYY = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fiP = findViewById(a.g.rp_result_root_bg);
        this.fiP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.3
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
        this.bNL = (FrameLayout) findViewById(a.g.rp_result_root_container);
        this.aUw = (HeadImageView) findViewById(a.g.rp_result_user_icon);
        this.aUw.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aUw.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aUw.setIsRound(true);
        this.aUw.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aUw.setAutoChangeStyle(true);
        this.aUw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fku = (TextView) findViewById(a.g.p_result_top10_desc);
        this.dKI = (TextView) findViewById(a.g.p_result_user_name);
        this.fkv = (TextView) findViewById(a.g.p_result_loot_amount);
        this.fiQ = (LinearLayout) findViewById(a.g.rp_result_content);
        this.fkw = (TextView) findViewById(a.g.p_result_send_gift);
        this.fkx = (BdListView) findViewById(a.g.p_result_listview);
        this.fkw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaRedPacketSnatchResultActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaRedPacketSnatchResultActivity.this.finish();
                AlaRedPacketSnatchResultActivity.this.buQ();
            }
        });
        this.fiQ.setVisibility(8);
        this.fkw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        w wVar = new w();
        wVar.azo = -1;
        wVar.azp = -1;
        wVar.azr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    public void a(com.baidu.tieba.ala.data.e eVar) {
        String str;
        this.fkz = eVar;
        this.fiQ.setVisibility(0);
        this.fkw.setVisibility(0);
        if (!StringUtils.isNullObject(eVar.portrait)) {
            k.a(this.aUw, eVar.portrait, true, false);
        }
        this.dKI.setText(eVar.userName);
        if (eVar.fJj) {
            String format = String.format(getPageContext().getResources().getString(a.i.snatch_red_packet_amount_desc), Long.valueOf(eVar.fIR));
            this.fkw.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fiQ.getLayoutParams();
            layoutParams.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds184);
            this.fiQ.setLayoutParams(layoutParams);
            str = format;
        } else {
            String string = getPageContext().getResources().getString(a.i.snatch_red_packet_failed_1);
            this.fkw.setVisibility(8);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fiQ.getLayoutParams();
            layoutParams2.bottomMargin = getPageContext().getResources().getDimensionPixelSize(a.e.sdk_ds50);
            this.fiQ.setLayoutParams(layoutParams2);
            str = string;
        }
        this.fkv.setText(str);
        Q(eVar.fJk);
    }

    private void Q(ArrayList<e.a> arrayList) {
        this.fky = new a(getPageContext().getPageActivity(), arrayList);
        this.fkx.setAdapter((ListAdapter) this.fky);
        this.fky.notifyDataSetChanged();
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
        jU(configuration.orientation == 2);
    }

    private void jU(boolean z) {
        if (z) {
            h.X(this.bNL);
            this.bNL.setScaleX(0.85f);
            this.bNL.setScaleY(0.85f);
            return;
        }
        h.Y(this.bNL);
        this.bNL.setScaleX(1.0f);
        this.bNL.setScaleY(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fkA != null) {
            this.fkA.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.fkB);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        private ArrayList<e.a> fkE;
        private Context mContext;

        public a(Context context, ArrayList<e.a> arrayList) {
            this.mContext = context;
            this.fkE = arrayList;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.fkE != null) {
                return this.fkE.size();
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: qb */
        public e.a getItem(int i) {
            if (this.fkE != null) {
                return this.fkE.get(i);
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
                bVar2.aTx = (HeadImageView) view.findViewById(a.g.rp_user_list_icon);
                bVar2.aTx.setIsRound(true);
                bVar2.aTx.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
                bVar2.aTx.setAutoChangeStyle(true);
                bVar2.aTx.setScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar2.fkF = (TextView) view.findViewById(a.g.rp_user_list_name);
                bVar2.fkG = (TextView) view.findViewById(a.g.rp_user_list_amount);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            e.a item = getItem(i);
            if (item != null) {
                if (!StringUtils.isNullObject(item.portrait)) {
                    k.a(bVar.aTx, item.portrait, true, false);
                }
                bVar.fkF.setText(item.userName);
                bVar.fkG.setText(String.format(this.mContext.getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(item.fJl)));
            }
            return view;
        }
    }

    /* loaded from: classes4.dex */
    private static class b {
        public HeadImageView aTx;
        public TextView fkF;
        public TextView fkG;

        private b() {
        }
    }
}

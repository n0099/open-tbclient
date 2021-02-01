package com.baidu.tieba.ala.headline.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.an.c;
import com.baidu.live.data.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.g;
import com.baidu.live.gift.h;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetHeadlineView extends RelativeLayout {
    private ab bxN;
    private ArrayList<g> eVV;
    public RelativeLayout hdI;
    private TextView hdT;
    private b hdU;
    private TextView hdV;
    private HeadImageView hdW;
    private TextView hdX;
    private TextView hdY;
    public Button hdZ;
    public long hea;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eVV = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eVV = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.hdV = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.hdI = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.hdZ = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.hdZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.hdW = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.hdW.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hdW.setIsRound(true);
        this.hdW.setAutoChangeStyle(false);
        this.hdX = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.hdU = new b(getContext());
        this.hdT = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.hdT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bxN.aIB.aHr) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eVV.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eVV.get(AlaGetHeadlineView.this.hdU.bWQ());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.DW())) {
                            AlaGetHeadlineView.this.i((g) AlaGetHeadlineView.this.eVV.get(AlaGetHeadlineView.this.hdU.bWQ()));
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(AlaGetHeadlineView.this.mContext, 0L, AlaGetHeadlineView.this.otherParams, true, "", true)));
                        return;
                    } else {
                        return;
                    }
                }
                ViewHelper.skipToLoginActivity(AlaGetHeadlineView.this.mContext);
            }
        });
        this.mListView = (BdListView) this.mView.findViewById(a.f.get_view_gift_list);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlaGetHeadlineView.this.hdU.uE(i);
                AlaGetHeadlineView.this.hdU.notifyDataSetChanged();
            }
        });
        this.hdY = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.hdY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bxN.aIB.aHC;
                cVar.bWs = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hdU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        ac.a(gVar, Long.parseLong(gVar.DW()), this.bxN.aId.userId + "", this.bxN.aId.userName, this.bxN.mLiveInfo.live_id + "", this.bxN.mLiveInfo.room_id + "", this.bxN.mLiveInfo.appId + "", this.bxN.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(ab abVar, String str) {
        this.otherParams = str;
        this.bxN = abVar;
        this.eVV.clear();
        setData2View(abVar);
    }

    private void setData2View(ab abVar) {
        if (this.hea > 0 && abVar.aIB.aHs > 0 && abVar.aIB.aHu > abVar.aIB.aHs) {
            this.hdV.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aIB.aHu));
            t(abVar.aIB.aHu);
        } else {
            this.hdV.setText(com.baidu.tieba.ala.headline.a.fs(abVar.aIB.aHs));
            t(abVar.aIB.aHs);
            this.hdU.bWR();
        }
        this.hdW.startLoad(abVar.aId.portrait, 12, false, false);
        this.hdX.setText(abVar.aId.nickName);
    }

    private void t(double d) {
        String Fs = ac.Fs();
        if (Fs != null && Fs.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.c(new JSONObject(Fs), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.HC().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().Ew()) {
                    if (gVar.aVW) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.fP(ceil + "");
                        this.eVV.add(gVar);
                    }
                }
            }
            Y(this.eVV);
            this.hdU.a(this.eVV, d);
        }
    }

    private void Y(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.DW()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.DW()) * Long.parseLong(gVar2.getPrice()));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}

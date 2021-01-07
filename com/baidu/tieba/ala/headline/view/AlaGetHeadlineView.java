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
import com.baidu.live.ap.c;
import com.baidu.live.data.x;
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
    private x bzc;
    private ArrayList<g> eYq;
    public RelativeLayout hfE;
    private TextView hfQ;
    private b hfR;
    private TextView hfS;
    private HeadImageView hfT;
    private TextView hfU;
    private TextView hfV;
    public Button hfW;
    public long hfX;
    private Activity mActivity;
    Context mContext;
    private BdListView mListView;
    private View mView;
    String otherParams;

    public AlaGetHeadlineView(Context context) {
        super(context);
        this.eYq = new ArrayList<>();
        this.otherParams = "";
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlaGetHeadlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYq = new ArrayList<>();
        this.otherParams = "";
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.sdk_get_headline_dialog, (ViewGroup) this, true);
        this.hfS = (TextView) this.mView.findViewById(a.f.get_view_now_score);
        this.hfE = (RelativeLayout) this.mView.findViewById(a.f.get_view_root_container);
        this.hfW = (Button) this.mView.findViewById(a.f.get_view_horizontal_close_button);
        this.hfW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaGetHeadlineView.this.mActivity.finish();
            }
        });
        this.hfT = (HeadImageView) this.mView.findViewById(a.f.get_view_live_head);
        this.hfT.setDefaultBgResource(a.e.sdk_default_avatar);
        this.hfT.setIsRound(true);
        this.hfT.setAutoChangeStyle(false);
        this.hfU = (TextView) this.mView.findViewById(a.f.get_view_live_name);
        this.hfR = new b(getContext());
        this.hfQ = (TextView) this.mView.findViewById(a.f.get_headline_button);
        this.hfQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TbadkCoreApplication.isLogin()) {
                    if (!AlaGetHeadlineView.this.bzc.aKS.aJI) {
                        BdUtilHelper.showToast(AlaGetHeadlineView.this.mActivity, AlaGetHeadlineView.this.getResources().getString(a.h.sdk_get_headline_not_open_tip));
                        AlaGetHeadlineView.this.mActivity.finish();
                        return;
                    } else if (!AlaGetHeadlineView.this.eYq.isEmpty()) {
                        long j = TbadkCoreApplication.getInst().currentAccountTdouNum;
                        g gVar = (g) AlaGetHeadlineView.this.eYq.get(AlaGetHeadlineView.this.hfR.cae());
                        if (j >= Long.parseLong(gVar.getPrice()) * Long.parseLong(gVar.GB())) {
                            AlaGetHeadlineView.this.i((g) AlaGetHeadlineView.this.eYq.get(AlaGetHeadlineView.this.hfR.cae()));
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
                AlaGetHeadlineView.this.hfR.we(i);
                AlaGetHeadlineView.this.hfR.notifyDataSetChanged();
            }
        });
        this.hfV = (TextView) this.mView.findViewById(a.f.get_view_get_headline_support);
        this.hfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = new c();
                cVar.url = AlaGetHeadlineView.this.bzc.aKS.aJT;
                cVar.bXf = 0.8f;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913244, cVar));
            }
        });
        this.mListView.setAdapter((ListAdapter) this.hfR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(g gVar) {
        ac.a(gVar, Long.parseLong(gVar.GB()), this.bzc.aKu.userId + "", this.bzc.aKu.userName, this.bzc.mLiveInfo.live_id + "", this.bzc.mLiveInfo.room_id + "", this.bzc.mLiveInfo.appId + "", this.bzc.mLiveInfo.feed_id + "", this.otherParams, 0L);
        this.mActivity.finish();
    }

    public void setData(x xVar, String str) {
        this.otherParams = str;
        this.bzc = xVar;
        this.eYq.clear();
        setData2View(xVar);
    }

    private void setData2View(x xVar) {
        if (this.hfX > 0 && xVar.aKS.aJJ > 0 && xVar.aKS.aJL > xVar.aKS.aJJ) {
            this.hfS.setText(com.baidu.tieba.ala.headline.a.fm(xVar.aKS.aJL));
            z(xVar.aKS.aJL);
        } else {
            this.hfS.setText(com.baidu.tieba.ala.headline.a.fm(xVar.aKS.aJJ));
            z(xVar.aKS.aJJ);
            this.hfR.caf();
        }
        this.hfT.startLoad(xVar.aKu.portrait, 12, false, false);
        this.hfU.setText(xVar.aKu.nickName);
    }

    private void z(double d) {
        String HX = ac.HX();
        if (HX != null && HX.length() != 0) {
            AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = new AlaSdkGetGiftListHttpResponseMessage();
            try {
                alaSdkGetGiftListHttpResponseMessage.c(new JSONObject(HX), true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<h> it = alaSdkGetGiftListHttpResponseMessage.Kh().iterator();
            while (it.hasNext()) {
                for (g gVar : it.next().Hb()) {
                    if (gVar.aXE) {
                        int ceil = (int) Math.ceil(d / Double.parseDouble(gVar.getPrice()));
                        if (ceil == ((int) Math.floor(d / Double.parseDouble(gVar.getPrice())))) {
                            ceil++;
                        }
                        gVar.gG(ceil + "");
                        this.eYq.add(gVar);
                    }
                }
            }
            ae(this.eYq);
            this.hfR.a(this.eYq, d);
        }
    }

    private void ae(ArrayList<g> arrayList) {
        Collections.sort(arrayList, new Comparator<g>() { // from class: com.baidu.tieba.ala.headline.view.AlaGetHeadlineView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(g gVar, g gVar2) {
                long parseLong = (Long.parseLong(gVar.GB()) * Long.parseLong(gVar.getPrice())) - (Long.parseLong(gVar2.GB()) * Long.parseLong(gVar2.getPrice()));
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

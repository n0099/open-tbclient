package com.baidu.tieba.ala.anchortask.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.ab;
import com.baidu.live.data.cj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
import com.baidu.tieba.ala.anchortask.b.c;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorBannerViewPager;
import com.baidu.tieba.ala.anchortask.viewpager.AlaAnchorViewPagerDot;
import com.baidu.tieba.ala.anchortask.viewpager.MyPagerAdapter;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements com.baidu.live.b.a {
    private ab alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gKH;
    private c gKI;
    private String gKJ;
    private int gKM;
    private int gKN;
    private b gKO;
    private AlaAnchorBannerViewPager gKP;
    private MyPagerAdapter gKR;
    private AlaAnchorViewPagerDot gKS;
    private int gKT;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gKK = new Handler();
    private boolean gKL = false;
    private ArrayList<View> gKQ = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bSD();
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gKU = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gKO.gLc.setCanVisible(true);
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gKJ)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gKJ));
            }
            a.this.bSD();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gKV = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gKS.ub(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gKW = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gKH != null) {
                a.this.gKI = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gKI;
                if (a.this.gKI != null && a.this.gKI.gLA != null) {
                    a.this.gKJ = a.this.gKI.gKJ;
                    a.this.bSE();
                    boolean a2 = a.this.gKH.a(a.this.gKI.gLA);
                    if (a.this.gKT == 1) {
                        a.this.gKO.gLc.setCanVisible(true);
                        if (a2) {
                            if (a.this.gKQ.size() <= 1 && a.this.gKH != null) {
                                a.this.gKQ.add(a.this.gKH.getView());
                                a.this.gKP.setAdapter(new MyPagerAdapter(a.this.context, a.this.gKQ));
                                a.this.gKS.uc(a.this.gKQ.size());
                            }
                        } else if (a.this.gKQ.size() == 2) {
                            a.this.gKQ.remove(1);
                            a.this.gKP.setAdapter(new MyPagerAdapter(a.this.context, a.this.gKQ));
                            a.this.gKS.uc(a.this.gKQ.size());
                        }
                    } else if (!a2) {
                        a.this.gKQ.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gKH != null) {
                        a.this.gKQ.clear();
                        a.this.gKQ.add(a.this.gKH.getView());
                        a.this.gKP.setAdapter(new MyPagerAdapter(a.this.context, a.this.gKQ));
                        a.this.gKS.uc(a.this.gKQ.size());
                    }
                    if (a.this.gKI.gLA.gLo == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gKX = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gKP.getCurrentItem() + 1;
                    if (a.this.gKQ.size() > 0) {
                        a.this.gKP.setCurrentItem(currentItem % a.this.gKQ.size());
                        a.this.gKS.ub(currentItem % a.this.gKQ.size());
                    }
                }
            });
            a.this.gKK.postDelayed(a.this.gKX, 10000L);
        }
    };
    CustomMessageListener gKY = new CustomMessageListener(2913284) { // from class: com.baidu.tieba.ala.anchortask.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gKP != null) {
                a.this.gKP.setVisibility(8);
            }
        }
    };
    CustomMessageListener gKZ = new CustomMessageListener(2913283) { // from class: com.baidu.tieba.ala.anchortask.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gKP != null) {
                a.this.gKP.setVisibility(0);
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gKH = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gKO = new b(context);
        this.gKH.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gKH.getView() != null) {
            this.gKH.getView().setOnClickListener(this.onClickListener);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        cj cjVar = com.baidu.live.ae.a.Qj().bAS.aPW;
        this.mActivity = activity;
        if (cjVar != null && this.gKO != null) {
            this.gKO.ua(i);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                z = cjVar.aQR == 1;
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                z = cjVar.aQS == 1;
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                z = cjVar.aQT == 1;
            } else if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = cjVar.aQU == 1;
            } else {
                z = false;
            }
            if (z) {
                if (this.gKH != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gKS = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gKP = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gKP.requestDisallowInterceptTouchEvent(true);
                    this.gKT = i;
                    if (i == 1) {
                        this.gKQ.add(this.gKO.gLc.getView());
                        this.gKO.gLc.setCanVisible(false);
                        this.gKK.postDelayed(this.gKU, 10000L);
                    }
                    this.gKH.T(this.gKQ);
                    this.gKR = new MyPagerAdapter(this.context, this.gKQ);
                    this.gKP.setAdapter(this.gKR);
                    this.gKS.uc(this.gKQ.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gKK.postDelayed(this.gKX, 10000L);
                    this.gKP.addOnPageChangeListener(this.gKV);
                }
                this.handler.postDelayed(this.runnable, 10000L);
                MessageManager.getInstance().registerListener(this.gKY);
                MessageManager.getInstance().registerListener(this.gKZ);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ab abVar) {
        this.alaLiveShowData = abVar;
        this.gKO.a(abVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gKW);
    }

    public void bSD() {
        if (this.alaLiveShowData != null) {
            long j = this.alaLiveShowData.mLiveInfo.live_id;
            long j2 = this.alaLiveShowData.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.setAnchorId(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        if (this.gKI != null && this.gKI.gLA != null) {
            if (!this.gKL) {
                this.gKL = true;
                this.gKM = this.gKI.gLA.gLm;
                this.gKN = this.gKI.gLA.gLn;
            }
            int i = this.gKI.gLA.gLo;
            int i2 = this.gKI.gLA.gLp;
            int i3 = this.gKI.gLA.gLq;
            String str = null;
            if (this.gKM == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gKM == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gKM == 1 && i == 1) {
                if (i2 > this.gKN) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gKN) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str);
                    jSONObject.put("content_type", "custom_anchor_identity_update");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, jSONObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.gKM = i;
            this.gKN = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gKH != null) {
            this.gKH.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gKH != null) {
            this.gKH.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gKK.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gKW);
        MessageManager.getInstance().unRegisterListener(this.gKY);
        MessageManager.getInstance().unRegisterListener(this.gKZ);
        if (this.gKH != null) {
            this.gKH.onDestroy();
        }
        if (this.gKO != null) {
            this.gKO.onDestory();
        }
    }
}

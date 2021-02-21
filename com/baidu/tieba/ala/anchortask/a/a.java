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
    private com.baidu.tieba.ala.anchortask.c.a gKV;
    private c gKW;
    private String gKX;
    private int gLa;
    private int gLb;
    private b gLc;
    private AlaAnchorBannerViewPager gLd;
    private MyPagerAdapter gLf;
    private AlaAnchorViewPagerDot gLg;
    private int gLh;
    private Activity mActivity;
    private View mView;
    private Handler handler = new Handler();
    private Handler gKY = new Handler();
    private boolean gKZ = false;
    private ArrayList<View> gLe = new ArrayList<>();
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bSK();
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private Runnable gLi = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.gLc.gLq.setCanVisible(true);
        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gKX)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gKX));
            }
            a.this.bSK();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, AppStatusRules.DEFAULT_GRANULARITY);
        }
    };
    private SlideRatioViewPager.OnPageChangeListener gLj = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.4
        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.gLg.ub(i);
        }

        @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private HttpMessageListener gLk = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gKV != null) {
                a.this.gKW = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gKW;
                if (a.this.gKW != null && a.this.gKW.gLO != null) {
                    a.this.gKX = a.this.gKW.gKX;
                    a.this.bSL();
                    boolean a2 = a.this.gKV.a(a.this.gKW.gLO);
                    if (a.this.gLh == 1) {
                        a.this.gLc.gLq.setCanVisible(true);
                        if (a2) {
                            if (a.this.gLe.size() <= 1 && a.this.gKV != null) {
                                a.this.gLe.add(a.this.gKV.getView());
                                a.this.gLd.setAdapter(new MyPagerAdapter(a.this.context, a.this.gLe));
                                a.this.gLg.uc(a.this.gLe.size());
                            }
                        } else if (a.this.gLe.size() == 2) {
                            a.this.gLe.remove(1);
                            a.this.gLd.setAdapter(new MyPagerAdapter(a.this.context, a.this.gLe));
                            a.this.gLg.uc(a.this.gLe.size());
                        }
                    } else if (!a2) {
                        a.this.gLe.clear();
                        a.this.mView.setVisibility(8);
                    } else if (a.this.gKV != null) {
                        a.this.gLe.clear();
                        a.this.gLe.add(a.this.gKV.getView());
                        a.this.gLd.setAdapter(new MyPagerAdapter(a.this.context, a.this.gLe));
                        a.this.gLg.uc(a.this.gLe.size());
                    }
                    if (a.this.gKW.gLO.gLC == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };
    private Runnable gLl = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6
        @Override // java.lang.Runnable
        public void run() {
            a.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.6.1
                @Override // java.lang.Runnable
                public void run() {
                    int currentItem = a.this.gLd.getCurrentItem() + 1;
                    if (a.this.gLe.size() > 0) {
                        a.this.gLd.setCurrentItem(currentItem % a.this.gLe.size());
                        a.this.gLg.ub(currentItem % a.this.gLe.size());
                    }
                }
            });
            a.this.gKY.postDelayed(a.this.gLl, 10000L);
        }
    };
    CustomMessageListener gLm = new CustomMessageListener(2913284) { // from class: com.baidu.tieba.ala.anchortask.a.a.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gLd != null) {
                a.this.gLd.setVisibility(8);
            }
        }
    };
    CustomMessageListener gLn = new CustomMessageListener(2913283) { // from class: com.baidu.tieba.ala.anchortask.a.a.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && a.this.gLd != null) {
                a.this.gLd.setVisibility(0);
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gKV = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gLc = new b(context);
        this.gKV.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gKV.getView() != null) {
            this.gKV.getView().setOnClickListener(this.onClickListener);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Activity activity, int i) {
        boolean z;
        cj cjVar = com.baidu.live.ae.a.Qj().bAS.aPW;
        this.mActivity = activity;
        if (cjVar != null && this.gLc != null) {
            this.gLc.ua(i);
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
                if (this.gKV != null) {
                    this.mView = LayoutInflater.from(this.context).inflate(a.g.layout_anchor_viewpager, (ViewGroup) null);
                    this.gLg = (AlaAnchorViewPagerDot) this.mView.findViewById(a.f.anchor_task_dot);
                    this.mView.setId(a.f.anthor_task_viewpager_id);
                    this.gLd = (AlaAnchorBannerViewPager) this.mView.findViewById(a.f.anchor_view_pager);
                    this.gLd.requestDisallowInterceptTouchEvent(true);
                    this.gLh = i;
                    if (i == 1) {
                        this.gLe.add(this.gLc.gLq.getView());
                        this.gLc.gLq.setCanVisible(false);
                        this.gKY.postDelayed(this.gLi, 10000L);
                    }
                    this.gKV.T(this.gLe);
                    this.gLf = new MyPagerAdapter(this.context, this.gLe);
                    this.gLd.setAdapter(this.gLf);
                    this.gLg.uc(this.gLe.size());
                    viewGroup.addView(this.mView, layoutParams);
                    this.gKY.postDelayed(this.gLl, 10000L);
                    this.gLd.addOnPageChangeListener(this.gLj);
                }
                this.handler.postDelayed(this.runnable, 10000L);
                MessageManager.getInstance().registerListener(this.gLm);
                MessageManager.getInstance().registerListener(this.gLn);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ab abVar) {
        this.alaLiveShowData = abVar;
        this.gLc.a(abVar);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gLk);
    }

    public void bSK() {
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
    public void bSL() {
        if (this.gKW != null && this.gKW.gLO != null) {
            if (!this.gKZ) {
                this.gKZ = true;
                this.gLa = this.gKW.gLO.gLA;
                this.gLb = this.gKW.gLO.gLB;
            }
            int i = this.gKW.gLO.gLC;
            int i2 = this.gKW.gLO.gLD;
            int i3 = this.gKW.gLO.gLE;
            String str = null;
            if (this.gLa == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gLa == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gLa == 1 && i == 1) {
                if (i2 > this.gLb) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gLb) {
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
            this.gLa = i;
            this.gLb = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.gKV != null) {
            this.gKV.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.gKV != null) {
            this.gKV.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        this.gKY.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gLk);
        MessageManager.getInstance().unRegisterListener(this.gLm);
        MessageManager.getInstance().unRegisterListener(this.gLn);
        if (this.gKV != null) {
            this.gKV.onDestroy();
        }
        if (this.gLc != null) {
            this.gLc.onDestory();
        }
    }
}

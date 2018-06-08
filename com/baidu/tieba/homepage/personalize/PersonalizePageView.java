package com.baidu.tieba.homepage.personalize;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LabelRecommendActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.d;
import com.baidu.tieba.tbadkCore.data.m;
import com.baidu.tieba.view.FloatingAnimationView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener aDd;
    private f bpl;
    private PbListView btv;
    private View.OnClickListener dMQ;
    private BdTypeListView dMv;
    private l dPU;
    private com.baidu.tieba.homepage.framework.b dPV;
    private d dPW;
    private a dPX;
    private com.baidu.tieba.homepage.personalize.model.e dPY;
    private long dPZ;
    private FloatingAnimationView dQa;
    private boolean dQb;
    private NEGFeedBackView.a dQc;
    private d.a dQd;
    private CustomMessageListener diO;
    private boolean dik;
    private com.baidu.tieba.c.c djn;
    private View dju;
    private g mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private com.baidu.tbadk.j.g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dPW != null) {
            this.dPW.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dPX != null) {
            this.dPX.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dMv != null) {
            this.dMv.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dPU != null) {
            this.dPU.setPageUniqueId(bdUniqueId);
        }
        if (this.dPW != null) {
            this.dPW.j(bdUniqueId);
        }
        if (this.dPY != null) {
            this.dPY.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.aDd != null) {
            this.aDd.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aDd);
        }
        if (this.dPX != null) {
            this.dPX.setBdUniqueId(bdUniqueId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m a(FloatInfo floatInfo) {
        if (floatInfo == null) {
            return null;
        }
        m mVar = new m();
        mVar.tQ(String.valueOf(floatInfo.activity_id));
        mVar.dw(floatInfo.dynamic_url);
        mVar.db(floatInfo.end_time.longValue() * 1000);
        mVar.setStartTime(floatInfo.start_time.longValue() * 1000);
        mVar.tP(floatInfo.float_url);
        mVar.tO(floatInfo.jump_url);
        mVar.setType(floatInfo.show_type.intValue());
        return mVar;
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dPZ = 0L;
        this.mSkinType = 3;
        this.dik = false;
        this.dQb = false;
        this.dQc = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new am("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dQd = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aP(int i, int i2) {
                if (PersonalizePageView.this.dPV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aBV = PersonalizePageView.this.aBV();
                PersonalizePageView.this.TI();
                if (aBV) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dPV.aO(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dPV != null) {
                    PersonalizePageView.this.dPV.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dMv.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dMv.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TI();
                m a = PersonalizePageView.this.a(PersonalizePageView.this.dPW.aCO());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.djn != null) {
                    PersonalizePageView.this.djn.a(a);
                }
            }
        };
        this.aDd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aCD();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.SJ();
            }
        };
        this.diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dik = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dPZ = 0L;
        this.mSkinType = 3;
        this.dik = false;
        this.dQb = false;
        this.dQc = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new am("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        sb.append(arrayList.get(i)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dQd = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aP(int i, int i2) {
                if (PersonalizePageView.this.dPV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aBV = PersonalizePageView.this.aBV();
                PersonalizePageView.this.TI();
                if (aBV) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dPV.aO(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dPV != null) {
                    PersonalizePageView.this.dPV.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i != 1) {
                    PersonalizePageView.this.dMv.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dMv.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TI();
                m a = PersonalizePageView.this.a(PersonalizePageView.this.dPW.aCO());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.djn != null) {
                    PersonalizePageView.this.djn.a(a);
                }
            }
        };
        this.aDd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aCD();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.SJ();
            }
        };
        this.diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dik = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dPZ = 0L;
        this.mSkinType = 3;
        this.dik = false;
        this.dQb = false;
        this.dQc = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new am("c11693").ah("obj_locate", "1").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new am("c11989").ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(arrayList.get(i2)).append(",");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new am("c11693").ah("obj_locate", sb.toString()).ah(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ah("tid", aiVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dQd = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aP(int i2, int i22) {
                if (PersonalizePageView.this.dPV == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.hideLoadingView();
                    return;
                }
                boolean aBV = PersonalizePageView.this.aBV();
                PersonalizePageView.this.TI();
                if (aBV) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dPV.aO(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dPV != null) {
                    PersonalizePageView.this.dPV.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.hideLoadingView();
                if (i2 != 1) {
                    PersonalizePageView.this.dMv.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.jD()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dMv.setVisibility(0);
                PersonalizePageView.this.hideLoadingView();
                PersonalizePageView.this.TI();
                m a = PersonalizePageView.this.a(PersonalizePageView.this.dPW.aCO());
                PersonalizePageView.this.bA(PersonalizePageView.this.getContext());
                if (PersonalizePageView.this.djn != null) {
                    PersonalizePageView.this.djn.a(a);
                }
            }
        };
        this.aDd = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                List<DownloadData> data;
                if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
                    boolean z = false;
                    for (DownloadData downloadData : data) {
                        z = downloadData.getStatus() == 0 ? true : z;
                    }
                    if (z) {
                        com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.aCD();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dMQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalizePageView.this.SJ();
            }
        };
        this.diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.dik = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dMv = new BdTypeListView(context);
        this.dMv.setDividerHeight(0);
        this.dMv.setSelector(17170445);
        this.btv = new PbListView(context);
        this.btv.getView();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.Ao();
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.dw(d.C0141d.cp_cont_e);
        this.btv.setHeight(com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        this.btv.setOnClickListener(this.dMQ);
        this.dMv.setNextPage(this.btv);
        com.baidu.adp.base.e<?> ad = i.ad(context);
        if (ad instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ad;
        }
        this.mPullView = new g(this.pageContext);
        this.dMv.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.dju = BdListViewHelper.a(context, this.dMv, BdListViewHelper.HeadType.DEFAULT);
        this.dPY = new com.baidu.tieba.homepage.personalize.model.e();
        this.dPU = new l(context, this.dMv);
        this.dPU.b(this.dPY);
        this.dPW = new d(this.pageContext, this.dMv, this.dPU);
        this.dPX = new a(this.pageContext);
        addView(this.dMv);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.diO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(Context context) {
        if (this.dQa == null) {
            this.dQa = new FloatingAnimationView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.e(context, d.e.tbds200), com.baidu.adp.lib.util.l.e(context, d.e.tbds200));
            layoutParams.gravity = 85;
            layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds200);
            addView(this.dQa, layoutParams);
            this.dQa.setVisibility(8);
            this.dQa.setPageId(this.pageContext.getUniqueId());
            this.djn = new com.baidu.tieba.c.c(this.pageContext, this.dQa, 1);
        }
    }

    public void axa() {
        this.dPU.a(this.dQc);
        this.dPW.a(this.dQd);
        this.dPX.a(this);
        this.mPullView.a(new f.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                com.baidu.tieba.a.d.Qe().ix("page_recommend");
                PersonalizePageView.this.dPW.update();
            }
        });
        this.mPullView.a(new f.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tbadk.core.view.f.c
            public void aT(boolean z) {
                if (PersonalizePageView.this.dPW != null) {
                    if (PersonalizePageView.this.dPW.aug() != null) {
                        PersonalizePageView.this.dPW.aug().aDT();
                    }
                    PersonalizePageView.this.dPW.gC(false);
                }
            }
        });
        this.dMv.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.SJ();
            }
        });
        this.dMv.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dPZ >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dPW.aQ(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new f.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.tbadk.core.view.f.a
            public void c(View view, boolean z) {
                if (PersonalizePageView.this.dPW != null) {
                    PersonalizePageView.this.dPW.gC(true);
                    PersonalizePageView.this.dPW.aCH();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.dMv.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                if (view != null) {
                    if (PersonalizePageView.this.dPW != null && PersonalizePageView.this.dPW.aug() != null) {
                        PersonalizePageView.this.dPW.aug().aP(view);
                    }
                    if (view.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view.getTag()).ajG().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dPV = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.btv != null) {
            this.btv.As();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dPW.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dPW != null) {
            this.dPW.gA(!z);
        }
        this.dQb = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dQb;
    }

    public void f(Long l) {
        this.dPW.f(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.dju != null && this.dju.getLayoutParams() != null) {
            if (this.dPW != null) {
                this.dPW.setHeaderViewHeight(i);
            }
            if (this.dPX != null) {
                this.dPX.setHeaderViewHeight(i);
            }
            this.dju.getLayoutParams().height = i;
            this.dju.setLayoutParams(this.dju.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(t tVar) {
        if (this.dPW != null) {
            this.dPW.setRecommendFrsNavigationAnimDispatcher(tVar);
        }
    }

    public void showFloatingView() {
        if (this.dPW != null) {
            this.dPW.showFloatingView();
        }
    }

    public void aCC() {
        if (this.dPW != null) {
            this.dPW.aCC();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bpl != null) {
                this.bpl.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dy(i);
            }
            if (this.btv != null) {
                this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_d));
                this.btv.dy(i);
            }
            this.dPU.onChangeSkinType(i);
            al.j(this, d.C0141d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void ab(String str, int i) {
        if (this.btv != null) {
            this.btv.As();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dPW.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.j.g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (PersonalizePageView.this.dPW != null) {
                        PersonalizePageView.this.dPW.update();
                    }
                }
            });
        }
        this.refreshView.ff(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view, z);
        this.refreshView.IX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TI() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        if (this.bpl != null) {
            this.bpl.P(this);
            this.bpl = null;
            this.dMv.setNextPage(this.btv);
        }
        if (this.dPV != null) {
            this.dPV.aCl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBV() {
        if (this.refreshView != null) {
            return this.refreshView.IP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bpl == null) {
            if (i < 0) {
                this.bpl = new com.baidu.tbadk.j.f(getContext());
            } else {
                this.bpl = new com.baidu.tbadk.j.f(getContext(), i);
            }
            this.bpl.onChangeSkinType();
        }
        this.bpl.d(this, z);
        this.dMv.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dPW != null) {
            this.dPW.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        if (this.djn != null) {
            this.djn.akO();
        }
        setViewForeground(false);
        if (this.dPW != null) {
            this.dPW.fD(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dPW != null) {
            this.dPW.gv(z);
        }
    }

    public void aBR() {
        if (this.dPW != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dPW.update();
        }
    }

    public void reload() {
        if (this.dMv != null) {
            showFloatingView();
            this.dMv.setSelection(0);
            if (this.dMv.isRefreshDone()) {
                if (this.dPW != null && this.dPW.aug() != null) {
                    this.dPW.aug().aDT();
                    this.dPW.gC(false);
                }
                this.dMv.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.diO);
        this.dPW.onDestroy();
        this.dPU.a((NEGFeedBackView.a) null);
        this.dPW.a((d.a) null);
        this.mPullView.a((f.b) null);
        this.mPullView.a((f.c) null);
        this.dMv.setOnSrollToBottomListener(null);
        this.mPullView.a((f.a) null);
        this.mPullView.release();
        if (this.bpl != null) {
            this.bpl.release();
        }
        this.dMv.setRecyclerListener(null);
        if (this.dPX != null) {
            this.dPX.onDestroy();
        }
        if (this.djn != null) {
            this.djn.onDestroy();
        }
    }

    public void onPause() {
        this.dPW.onPause();
    }

    public void onResume() {
        if (this.dik) {
            reload();
            this.dik = false;
        }
    }

    public void aCD() {
        if (this.dPU != null) {
            this.dPU.notifyDataSetChanged();
        }
    }

    public void aBX() {
        if (this.dPW != null) {
            this.dPW.fD(true);
        }
        v.ajh().cG(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void aCA() {
        this.dPW.aCN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        com.baidu.tieba.homepage.framework.a.aCk().h(System.currentTimeMillis(), 1);
        if (this.btv != null && !this.btv.Ax()) {
            this.btv.Ar();
            this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dPW.SJ();
    }
}

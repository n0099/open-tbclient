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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.j.f;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.s;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.v;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.a.l;
import com.baidu.tieba.homepage.personalize.d;
import com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.FloatInfo;
/* loaded from: classes2.dex */
public class PersonalizePageView extends FrameLayout {
    private final CustomMessageListener auR;
    private f bha;
    private PbListView blb;
    private boolean cXP;
    private View cYY;
    private CustomMessageListener cYt;
    private View.OnClickListener dAC;
    private BdTypeListView dAh;
    private l dDG;
    private com.baidu.tieba.homepage.framework.b dDH;
    private d dDI;
    private a dDJ;
    private com.baidu.tieba.homepage.personalize.model.e dDK;
    private long dDL;
    private QuizEntranceFloatingView dDM;
    private boolean dDN;
    private NEGFeedBackView.a dDO;
    private d.a dDP;
    private com.baidu.tbadk.core.view.f mPullView;
    private int mSkinType;
    private TbPageContext<?> pageContext;
    private g refreshView;

    public void setScrollFragmentTabHost(ScrollFragmentTabHost scrollFragmentTabHost) {
        if (this.dDI != null) {
            this.dDI.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
        if (this.dDJ != null) {
            this.dDJ.setScrollFragmentTabHost(scrollFragmentTabHost);
        }
    }

    public void completePullRefresh() {
        if (this.dAh != null) {
            this.dAh.completePullRefresh();
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.dDG != null) {
            this.dDG.setPageUniqueId(bdUniqueId);
        }
        if (this.dDI != null) {
            this.dDI.j(bdUniqueId);
        }
        if (this.dDK != null) {
            this.dDK.m(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
        if (this.auR != null) {
            this.auR.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.auR);
        }
        if (this.dDJ != null) {
            this.dDJ.setBdUniqueId(bdUniqueId);
        }
    }

    public PersonalizePageView(Context context) {
        super(context);
        this.dDL = 0L;
        this.mSkinType = 3;
        this.cXP = false;
        this.dDN = false;
        this.dDO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dDP = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i, int i2) {
                if (PersonalizePageView.this.dDH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDH.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dDH != null) {
                    PersonalizePageView.this.dDH.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Ou();
                if (i != 1) {
                    PersonalizePageView.this.dAh.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAh.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDI.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDM.setData(axV);
                    PersonalizePageView.this.dDM.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDM.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXP = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDL = 0L;
        this.mSkinType = 3;
        this.cXP = false;
        this.dDN = false;
        this.dDO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arrayList.size(); i++) {
                        sb.append(arrayList.get(i) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dDP = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i, int i2) {
                if (PersonalizePageView.this.dDH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDH.aN(i, i2);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i, int i2, int i3) {
                if (PersonalizePageView.this.dDH != null) {
                    PersonalizePageView.this.dDH.B(i, i2, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i, String str) {
                PersonalizePageView.this.Ou();
                if (i != 1) {
                    PersonalizePageView.this.dAh.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAh.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDI.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDM.setData(axV);
                    PersonalizePageView.this.dDM.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDM.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXP = true;
                    }
                }
            }
        };
        init(context);
    }

    public PersonalizePageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDL = 0L;
        this.mSkinType = 3;
        this.cXP = false;
        this.dDN = false;
        this.dDO = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.1
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar) {
                if (aiVar != null) {
                    TiebaStatic.log(new al("c11693").ac("obj_locate", "1").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                    TiebaStatic.log(new al("c11989").ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ai aiVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, ai aiVar) {
                if (arrayList != null && aiVar != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        sb.append(arrayList.get(i2) + Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    TiebaStatic.log(new al("c11693").ac("obj_locate", sb.toString()).ac(ImageViewerConfig.FORUM_ID, aiVar.getFid()).ac("tid", aiVar.getTid()).ac("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        };
        this.dDP = new d.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.6
            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void aO(int i2, int i22) {
                if (PersonalizePageView.this.dDH == null) {
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, TbadkCoreApplication.getInst().getString(d.k.neterror), true);
                    PersonalizePageView.this.Ou();
                    return;
                }
                boolean axe = PersonalizePageView.this.axe();
                PersonalizePageView.this.Qn();
                if (axe) {
                    PersonalizePageView.this.g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
                }
                PersonalizePageView.this.dDH.aN(i2, i22);
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void C(int i2, int i22, int i3) {
                if (PersonalizePageView.this.dDH != null) {
                    PersonalizePageView.this.dDH.B(i2, i22, i3);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onError(int i2, String str) {
                PersonalizePageView.this.Ou();
                if (i2 != 1) {
                    PersonalizePageView.this.dAh.setVisibility(8);
                    PersonalizePageView.this.showNetRefreshView(PersonalizePageView.this, str, true);
                } else if (j.gP()) {
                    PersonalizePageView.this.pageContext.showToast(str);
                }
            }

            @Override // com.baidu.tieba.homepage.personalize.d.a
            public void onSuccess() {
                PersonalizePageView.this.dAh.setVisibility(0);
                PersonalizePageView.this.Ou();
                PersonalizePageView.this.Qn();
                FloatInfo axV = PersonalizePageView.this.dDI.axV();
                if (axV != null) {
                    PersonalizePageView.this.dDM.setData(axV);
                    PersonalizePageView.this.dDM.setVisibility(com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("key_quiz_floating_switch", 0L) != axV.start_time.longValue() ? 0 : 8);
                    return;
                }
                PersonalizePageView.this.dDM.setVisibility(8);
            }
        };
        this.auR = new CustomMessageListener(2001118) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3
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
                        com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PersonalizePageView.this.axI();
                            }
                        }, TimeUnit.SECONDS.toMillis(2L));
                    }
                }
            }
        };
        this.dAC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalizePageView.this.Po();
            }
        };
        this.cYt = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    Object data = customResponsedMessage.getData();
                    if ((data instanceof String) && !TextUtils.isEmpty((String) data)) {
                        PersonalizePageView.this.cXP = true;
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.dAh = new BdTypeListView(context);
        this.dAh.setDividerHeight(0);
        this.dAh.setSelector(17170445);
        this.blb = new PbListView(context);
        this.blb.getView();
        this.blb.dv(d.C0126d.cp_bg_line_e);
        this.blb.wO();
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.du(d.C0126d.cp_cont_e);
        this.blb.setHeight(com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        this.blb.setOnClickListener(this.dAC);
        this.dAh.setNextPage(this.blb);
        com.baidu.adp.base.e<?> ab = i.ab(context);
        if (ab instanceof TbPageContext) {
            this.pageContext = (TbPageContext) ab;
        }
        this.mPullView = new com.baidu.tbadk.core.view.f(this.pageContext);
        this.dAh.setPullRefresh(this.mPullView);
        this.mPullView.setEnable(true);
        this.cYY = BdListViewHelper.a(context, this.dAh, BdListViewHelper.HeadType.DEFAULT);
        this.dDK = new com.baidu.tieba.homepage.personalize.model.e();
        this.dDG = new l(context, this.dAh);
        this.dDG.b(this.dDK);
        this.dDI = new d(this.pageContext, this.dAh, this.dDG);
        this.dDJ = new a(this.pageContext);
        addView(this.dAh);
        this.dDM = new QuizEntranceFloatingView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.baidu.adp.lib.util.l.e(context, d.e.tbds182), com.baidu.adp.lib.util.l.e(context, d.e.tbds182));
        layoutParams.gravity = 85;
        layoutParams.rightMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds18);
        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.e(context, d.e.tbds238);
        addView(this.dDM, layoutParams);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        MessageManager.getInstance().registerListener(this.cYt);
        this.dDM.setCallback(new QuizEntranceFloatingView.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.7
            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axJ() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 2));
                com.baidu.tbadk.browser.a.M(PersonalizePageView.this.getContext(), TbConfig.NANI_CAMPUS_SQUARE);
            }

            @Override // com.baidu.tieba.homepage.personalize.view.QuizEntranceFloatingView.a
            public void axK() {
                TiebaStatic.log(new al("c12913").r("obj_locate", 3));
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_quiz_floating_switch", PersonalizePageView.this.dDI.axV() == null ? 0L : PersonalizePageView.this.dDI.axV().start_time.longValue());
                PersonalizePageView.this.dDM.setVisibility(8);
            }
        });
        this.dDM.setVisibility(8);
    }

    public void asV() {
        this.dDG.a(this.dDO);
        this.dDI.a(this.dDP);
        this.dDJ.a(this);
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.8
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                com.baidu.tieba.a.d.MH().hX("page_recommend");
                PersonalizePageView.this.dDI.update();
            }
        });
        this.mPullView.a(new e.c() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.9
            @Override // com.baidu.tbadk.core.view.e.c
            public void aP(boolean z) {
                if (PersonalizePageView.this.dDI != null) {
                    if (PersonalizePageView.this.dDI.aqc() != null) {
                        PersonalizePageView.this.dDI.aqc().aza();
                    }
                    PersonalizePageView.this.dDI.gv(false);
                }
            }
        });
        this.dAh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                PersonalizePageView.this.Po();
            }
        });
        this.dAh.setOnScrollStopDelayedListener(new BdListView.d() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.11
            @Override // com.baidu.adp.widget.ListView.BdListView.d
            public void onScrollStop(int i, int i2) {
                if (System.currentTimeMillis() - PersonalizePageView.this.dDL >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                    PersonalizePageView.this.dDI.aP(i, i2);
                }
            }
        }, 1L);
        this.mPullView.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.12
            @Override // com.baidu.tbadk.core.view.e.a
            public void c(View view2, boolean z) {
                if (PersonalizePageView.this.dDI != null) {
                    PersonalizePageView.this.dDI.gv(true);
                    PersonalizePageView.this.dDI.axO();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016477, true));
            }
        });
        this.dAh.setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.13
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view2) {
                if (view2 != null) {
                    if (PersonalizePageView.this.dDI != null && PersonalizePageView.this.dDI.aqc() != null) {
                        PersonalizePageView.this.dDI.aqc().aM(view2);
                    }
                    if (view2.getTag() instanceof com.baidu.tieba.homepage.personalize.a.c) {
                        ((com.baidu.tieba.homepage.personalize.a.c) view2.getTag()).afY().stopPlay();
                    }
                }
            }
        });
    }

    public void setCallback(com.baidu.tieba.homepage.framework.b bVar) {
        this.dDH = bVar;
    }

    public void d(DataRes dataRes, boolean z, boolean z2) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDI.a(z, z2, dataRes, 0, null);
    }

    public void setIsUnreadTipShow(boolean z) {
        if (this.dDI != null) {
            this.dDI.gt(!z);
        }
        this.dDN = z;
    }

    public boolean getIsUnreadTipShow() {
        return this.dDN;
    }

    public void e(Long l) {
        this.dDI.e(l);
    }

    public void setHeaderViewHeight(int i) {
        if (this.cYY != null && this.cYY.getLayoutParams() != null) {
            if (this.dDI != null) {
                this.dDI.setHeaderViewHeight(i);
            }
            if (this.dDJ != null) {
                this.dDJ.setHeaderViewHeight(i);
            }
            this.cYY.getLayoutParams().height = i;
            this.cYY.setLayoutParams(this.cYY.getLayoutParams());
        }
    }

    public void setRecommendFrsNavigationAnimDispatcher(s sVar) {
        if (this.dDI != null) {
            this.dDI.setRecommendFrsNavigationAnimDispatcher(sVar);
        }
    }

    public void showFloatingView() {
        if (this.dDI != null) {
            this.dDI.showFloatingView();
        }
    }

    public void axH() {
        if (this.dDI != null) {
            this.dDI.axH();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.bha != null) {
                this.bha.onChangeSkinType();
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
            if (this.blb != null) {
                this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                this.blb.dw(i);
            }
            this.dDG.onChangeSkinType(i);
            ak.j(this, d.C0126d.cp_bg_line_d);
        }
        this.mSkinType = i;
    }

    public void Y(String str, int i) {
        if (this.blb != null) {
            this.blb.wS();
            this.blb.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDI.a(true, false, null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view2, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new g(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.PersonalizePageView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (PersonalizePageView.this.dDI != null) {
                        PersonalizePageView.this.dDI.update();
                    }
                }
            });
        }
        this.refreshView.fb(getContext().getResources().getDimensionPixelSize(d.e.ds280));
        this.refreshView.setSubText(str);
        this.refreshView.d(view2, z);
        this.refreshView.Fu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
        if (this.refreshView != null) {
            this.refreshView.P(this);
            this.refreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou() {
        if (this.bha != null) {
            this.bha.P(this);
            this.bha = null;
            this.dAh.setNextPage(this.blb);
        }
        if (this.dDH != null) {
            this.dDH.axr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axe() {
        if (this.refreshView != null) {
            return this.refreshView.Fm();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.bha == null) {
            if (i < 0) {
                this.bha = new f(getContext());
            } else {
                this.bha = new f(getContext(), i);
            }
            this.bha.onChangeSkinType();
        }
        this.bha.d(this, z);
        this.dAh.setNextPage(null);
    }

    public void setTabInForeBackgroundState(boolean z) {
        if (this.dDI != null) {
            this.dDI.setTabInForeBackgroundState(z);
        }
    }

    public void setViewForeground() {
        setViewForeground(false);
        if (this.dDI != null) {
            this.dDI.fx(false);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        int i = com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("show_is_uninterest_tag", 0);
        if (i < 1 && TbadkCoreApplication.getInst().isNoInterestTag() && this.pageContext != null) {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("show_is_uninterest_tag", i + 1);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LabelRecommendActivityConfig(this.pageContext.getContext(), 2)));
        }
    }

    public void setViewForeground(boolean z) {
        if (this.dDI != null) {
            this.dDI.go(z);
        }
    }

    public void axa() {
        if (this.dDI != null) {
            g(true, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds520));
            this.dDI.update();
        }
    }

    public void reload() {
        if (this.dAh != null) {
            showFloatingView();
            this.dAh.setSelection(0);
            if (this.dAh.isRefreshDone()) {
                if (this.dDI != null && this.dDI.aqc() != null) {
                    this.dDI.aqc().aza();
                    this.dDI.gv(false);
                }
                this.dAh.startPullRefresh();
            }
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYt);
        this.dDI.onDestroy();
        this.dDG.a((NEGFeedBackView.a) null);
        this.dDI.a((d.a) null);
        this.mPullView.a((e.b) null);
        this.mPullView.a((e.c) null);
        this.dAh.setOnSrollToBottomListener(null);
        this.mPullView.a((e.a) null);
        this.mPullView.release();
        if (this.bha != null) {
            this.bha.release();
        }
        this.dAh.setRecyclerListener(null);
        if (this.dDJ != null) {
            this.dDJ.onDestroy();
        }
    }

    public void onPause() {
        this.dDI.onPause();
    }

    public void onResume() {
        this.dDI.onResume();
        if (this.cXP) {
            reload();
            this.cXP = false;
        }
    }

    public void axI() {
        if (this.dDG != null) {
            this.dDG.notifyDataSetChanged();
        }
    }

    public void axg() {
        if (this.dDI != null) {
            this.dDI.fx(true);
        }
        v.afy().cB(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
    }

    public void axF() {
        this.dDI.axU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po() {
        com.baidu.tieba.homepage.framework.a.axq().i(System.currentTimeMillis(), 1);
        if (this.blb != null && !this.blb.wX()) {
            this.blb.wR();
            this.blb.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        this.dDI.Po();
    }
}

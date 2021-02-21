package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.l.g;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.TopicDetailActivity;
import com.baidu.tieba.homepage.topic.topicdetail.model.a;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class TopicDetailView extends RelativeLayout implements View.OnClickListener {
    private BdListView.e WH;
    private com.baidu.tbadk.editortools.pb.b fDP;
    private NoNetworkView gAv;
    private PbListView gAw;
    private g gJB;
    private NoNetworkView.a gyn;
    private BdTypeRecyclerView jNt;
    private ImageView jTD;
    private View jiW;
    private int kpA;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a kpB;
    a.RunnableC0749a kpC;
    private int kpD;
    private int kpE;
    private NewWriteModel.d kpF;
    private com.baidu.tieba.homepage.topic.topicdetail.a kpp;
    private TopicDetailHeadView kpq;
    private com.baidu.tieba.homepage.topic.topicdetail.adapter.b kpr;
    private View kps;
    private View kpt;
    private TextView kpu;
    private TextView kpv;
    private a kpw;
    private View kpx;
    private com.baidu.tieba.write.c kpy;
    private EditText kpz;
    private ImageView mBackImageView;
    private boolean mHasMore;
    private NavigationBar mNavigationBar;
    private TbPageContext<?> mPageContext;
    private h mRefreshView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private int mSkinType;
    private com.baidu.tieba.homepage.topic.topicdetail.a.a mTopicDetailData;

    public TopicDetailView(TbPageContext<?> tbPageContext, com.baidu.tieba.homepage.topic.topicdetail.a aVar, Bundle bundle) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.kpt = null;
        this.kpu = null;
        this.kpv = null;
        this.mHasMore = true;
        this.kpD = 0;
        this.kpE = 44;
        this.gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.kpp != null) {
                    TopicDetailView.this.kpp.loadData();
                }
            }
        };
        this.fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bBL() {
                if (TopicDetailView.this.kpy.dWx()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.kpy.dWz());
                    TopicDetailView.this.ss(true);
                    return true;
                }
                return false;
            }
        };
        this.kpF = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.kpw != null && TopicDetailView.this.kpw.bBh() != null) {
                    TopicDetailView.this.kpw.bBh().hide();
                }
                if (z) {
                    TopicDetailView.this.kpy.Vh(null);
                    TopicDetailView.this.kpy.bg(null);
                    TopicDetailView.this.kpy.zt(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.kpC = TopicDetailView.this.kpB.G(j, j2);
                            com.baidu.adp.lib.f.e.mA().postDelayed(TopicDetailView.this.kpC, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.kpy.bg(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.kpy.Vh(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.kpy.dWv())) {
                        TopicDetailView.this.ss(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.kpw != null) {
                    TopicDetailView.this.kpw.bCq();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jNt, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.kpD += i2;
                TopicDetailView.this.cSu();
            }
        };
        this.WH = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bSy();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gH(((com.baidu.tieba.homepage.topic.topicdetail.a.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).koQ);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kpp = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.jiW == null) {
            this.jiW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jiW.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.jiW.findViewById(R.id.widget_navi_back_button);
        }
        this.jTD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gAv = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gAv.a(this.gyn);
        this.kpt = findViewById(R.id.pb_editor_tool_comment);
        this.kpu = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.kpu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cSt();
            }
        });
        this.kpv = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.kps = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.kpw.bBh(), layoutParams);
        this.kpy = new com.baidu.tieba.write.c();
        this.kpx = findViewById(R.id.activity_topic_detail_editor_top);
        this.jNt = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jNt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jNt.setFadingEdgeLength(0);
        this.jNt.setOverScrollMode(2);
        this.jNt.setOnSrollToBottomListener(this.WH);
        this.jNt.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jNt, R.color.CAM_X0201);
        this.kpr = new com.baidu.tieba.homepage.topic.topicdetail.adapter.b(this.mPageContext, this.jNt);
        this.kpq = new TopicDetailHeadView(getContext());
        this.kpq.kpn.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Ce(int i) {
                TopicDetailView.this.Cd(i);
            }
        });
        if (this.gJB == null) {
            this.gAw = new PbListView(this.mPageContext.getPageActivity());
            this.gAw.getView();
        }
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.gAw.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.gAw.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.gAw.setText(getResources().getString(R.string.list_has_no_more));
        this.gAw.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.kpB == null) {
            this.kpB = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.kpB.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.kpw = (a) new b().fg(getContext());
        if (this.kpw != null) {
            this.kpw.a(this.mPageContext);
            this.kpw.b(this.kpF);
            this.kpw.a(this.fDP);
            this.kpw.bBh().kN(true);
            this.kpw.bBh().setBarBackgroundColorId(R.color.CAM_X0207);
            this.kpw.a((BaseActivity) getContext(), bundle);
            this.kpw.bCq();
            this.kpw.bBh().setId(R.id.topic_editor);
            this.kpz = this.kpw.cSs().getInputView();
            this.kpz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.kpy != null) {
                        if (!TopicDetailView.this.kpy.dWy()) {
                            TopicDetailView.this.ss(false);
                        }
                        TopicDetailView.this.kpy.zu(false);
                    }
                }
            });
        }
    }

    public void ss(boolean z) {
        if (this.kpz != null && this.kpz.getText() != null) {
            int selectionEnd = this.kpz.getSelectionEnd();
            SpannableStringBuilder d = this.kpy.d(this.kpz.getText());
            if (d != null) {
                this.kpy.zu(true);
                this.kpz.setText(d);
                if (z && this.kpy.dWw() >= 0) {
                    this.kpz.requestFocus();
                    this.kpz.setSelection(this.kpy.dWw());
                } else {
                    this.kpz.setSelection(selectionEnd);
                }
                this.kpy.zt(this.kpy.dWw() >= 0);
            }
        }
    }

    public void cSt() {
        if (bh.checkUpIsLogin(getContext())) {
            this.kpw.bCt();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd(int i) {
        this.kpA = i;
        this.kpv.setVisibility(0);
        if (i == 1) {
            this.kpv.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.kpv, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.kpv.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.kpv, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.kpv.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.kpv, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.kpv.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.kpv, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                WY();
            } else if (!this.mHasMore) {
                WY();
            } else {
                WX();
            }
            if (!StringUtils.isNull(aVar.ePt)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), au.cutChineseAndEnglishWithSuffix(aVar.ePt, 14, StringHelper.STRING_MORE)));
            }
            this.kpq.setData(aVar.koI);
            this.jNt.addHeaderView(this.kpq);
            this.kpr.setData(aVar.mDataList);
            if (this.mTopicDetailData.koI.koN != null) {
                if (this.mTopicDetailData.koI.koN.kqh.kqn) {
                    Cd(1);
                } else if (this.mTopicDetailData.koI.koN.kqi.kqn) {
                    Cd(2);
                } else {
                    Cd(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.kpv.setVisibility(8);
            }
            this.kpu.setPadding(dimens, 0, 0, 0);
            cSu();
        }
    }

    public void setNextData(int i, boolean z, List<n> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            WY();
        } else {
            WX();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (n nVar : list) {
                if (nVar instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.a.c) nVar).koS = this.mTopicDetailData.cSo();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jNt.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSy() {
        this.jNt.setNextPage(null);
    }

    public void WX() {
        this.mHasMore = true;
        this.jNt.setNextPage(this.gAw);
        this.gAw.startLoadData();
    }

    public void WY() {
        this.jNt.setNextPage(this.gAw);
        this.gAw.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiW) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jTD && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            buF();
            TiebaStatic.log(new ar("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void buF() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.ePt;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.koH) ? null : Uri.parse(this.mTopicDetailData.koH);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fuN = true;
            shareItem.extData = valueOf;
            shareItem.imageUri = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(getContext(), shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                    l.showToast(TopicDetailView.this.getContext(), view.getResources().getString(R.string.copy_pb_url_success));
                }
            });
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            cSu();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.kpt, R.color.CAM_X0207);
            ap.setViewTextColor(this.kpu, R.color.CAM_X0109);
            this.kpu.setBackgroundDrawable(ap.aL(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            Cd(this.kpA);
            SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jTD != null) {
                SvgManager.bsR().a(this.jTD, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gAv != null) {
                this.gAv.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gJB != null) {
                this.gJB.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kpw != null && this.kpw.bBh() != null) {
                this.kpw.bBh().onChangeSkinType(this.mSkinType);
            }
            if (this.gAw != null) {
                this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gAw.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.gAw.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.gAw.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.kpq != null) {
                this.kpq.onChangeSkinType();
            }
            if (this.kpr != null) {
                this.kpr.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jNt, R.color.CAM_X0205);
        }
    }

    public void ir(boolean z) {
        if (!cqS()) {
            if (this.gJB == null) {
                this.gJB = new g(getContext());
                this.gJB.onChangeSkinType();
            }
            this.gJB.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gJB != null) {
            this.gJB.dettachView(this);
            this.gJB = null;
        }
    }

    public boolean cqS() {
        if (this.gJB != null) {
            return this.gJB.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqT()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.kpp != null) {
                            TopicDetailView.this.kpp.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jNt.setVisibility(8);
            SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void WZ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jNt.setVisibility(0);
        SvgManager.bsR().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cqT() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        destroy();
        super.onDetachedFromWindow();
    }

    public void destroy() {
        this.jNt.setOnSrollToBottomListener(null);
        if (this.gAv != null) {
            this.gAv.b(this.gyn);
        }
        if (this.kpw != null) {
            this.kpw.onDestory();
        }
        if (this.kpC != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.kpC);
        }
        hideLoadingView();
        WZ();
    }

    public a getEditor() {
        return this.kpw;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.kpx != null) {
            ViewGroup.LayoutParams layoutParams = this.kpx.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.kpw.bBh().isVisible()) {
                    layoutParams2.addRule(2, this.kpw.bBh().getId());
                } else {
                    layoutParams2.addRule(2, this.kps.getId());
                }
                this.kpx.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aH(cb cbVar) {
        int i;
        com.baidu.tieba.homepage.topic.topicdetail.a.c cVar;
        int i2 = 0;
        Iterator<n> it = this.mTopicDetailData.mDataList.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                cVar = null;
                break;
            }
            n next = it.next();
            if (next instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                cVar = (com.baidu.tieba.homepage.topic.topicdetail.a.c) next;
                break;
            }
            i2 = i + 1;
        }
        if (cVar != null) {
            com.baidu.tieba.homepage.topic.topicdetail.a.c cVar2 = new com.baidu.tieba.homepage.topic.topicdetail.a.c();
            cVar2.koQ = cVar.koQ;
            cVar2.eJQ = cbVar;
            cVar2.source = 2;
            cVar2.koR = this.kpA;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.koS = this.mTopicDetailData.cSo();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.kpr.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSu() {
        if (this.mTopicDetailData != null && this.kpq != null) {
            if (this.kpD > this.kpE) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cSv()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cSv() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.kpq.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.kpq.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}

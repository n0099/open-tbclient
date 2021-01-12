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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
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
    private BdListView.e WL;
    private com.baidu.tbadk.editortools.pb.b fBA;
    private g gGD;
    private NoNetworkView.a gvp;
    private NoNetworkView gxx;
    private PbListView gxy;
    private BdTypeRecyclerView jHB;
    private ImageView jMm;
    private View jdb;
    private com.baidu.tieba.homepage.topic.topicdetail.a kgT;
    private TopicDetailHeadView kgU;
    private com.baidu.tieba.homepage.topic.topicdetail.adapter.b kgV;
    private View kgW;
    private View kgX;
    private TextView kgY;
    private TextView kgZ;
    private a kha;
    private View khb;
    private com.baidu.tieba.write.c khc;
    private EditText khd;
    private int khe;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a khf;
    a.RunnableC0746a khg;
    private int khh;
    private int khi;
    private NewWriteModel.d khj;
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
        this.kgX = null;
        this.kgY = null;
        this.kgZ = null;
        this.mHasMore = true;
        this.khh = 0;
        this.khi = 44;
        this.gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.kgT != null) {
                    TopicDetailView.this.kgT.loadData();
                }
            }
        };
        this.fBA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bBt() {
                if (TopicDetailView.this.khc.dUb()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.khc.dUd());
                    TopicDetailView.this.sf(true);
                    return true;
                }
                return false;
            }
        };
        this.khj = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.kha != null && TopicDetailView.this.kha.bAP() != null) {
                    TopicDetailView.this.kha.bAP().hide();
                }
                if (z) {
                    TopicDetailView.this.khc.TW(null);
                    TopicDetailView.this.khc.bh(null);
                    TopicDetailView.this.khc.yX(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.khg = TopicDetailView.this.khf.C(j, j2);
                            com.baidu.adp.lib.f.e.mB().postDelayed(TopicDetailView.this.khg, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.khc.bh(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.khc.TW(postWriteCallBackData.getErrorString());
                    if (!x.isEmpty(TopicDetailView.this.khc.dTZ())) {
                        TopicDetailView.this.sf(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.kha != null) {
                    TopicDetailView.this.kha.bBY();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jHB, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.khh += i2;
                TopicDetailView.this.cQo();
            }
        };
        this.WL = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bRO();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gC(((com.baidu.tieba.homepage.topic.topicdetail.a.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).kgu);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.kgT = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.jdb == null) {
            this.jdb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jdb.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.jdb.findViewById(R.id.widget_navi_back_button);
        }
        this.jMm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gxx = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gxx.a(this.gvp);
        this.kgX = findViewById(R.id.pb_editor_tool_comment);
        this.kgY = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.kgY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cQn();
            }
        });
        this.kgZ = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.kgW = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.kha.bAP(), layoutParams);
        this.khc = new com.baidu.tieba.write.c();
        this.khb = findViewById(R.id.activity_topic_detail_editor_top);
        this.jHB = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jHB.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jHB.setFadingEdgeLength(0);
        this.jHB.setOverScrollMode(2);
        this.jHB.setOnSrollToBottomListener(this.WL);
        this.jHB.addOnScrollListener(this.mScrollListener);
        ao.setBackgroundColor(this.jHB, R.color.CAM_X0201);
        this.kgV = new com.baidu.tieba.homepage.topic.topicdetail.adapter.b(this.mPageContext, this.jHB);
        this.kgU = new TopicDetailHeadView(getContext());
        this.kgU.kgR.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void BN(int i) {
                TopicDetailView.this.BM(i);
            }
        });
        if (this.gGD == null) {
            this.gxy = new PbListView(this.mPageContext.getPageActivity());
            this.gxy.getView();
        }
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0110));
        this.gxy.setContainerBackgroundColorResId(ao.getColor(R.color.CAM_X0201));
        this.gxy.setLineColorResource(ao.getColor(R.color.CAM_X0204));
        this.gxy.setText(getResources().getString(R.string.list_has_no_more));
        this.gxy.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.khf == null) {
            this.khf = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.khf.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.kha = (a) new b().fh(getContext());
        if (this.kha != null) {
            this.kha.a(this.mPageContext);
            this.kha.b(this.khj);
            this.kha.a(this.fBA);
            this.kha.bAP().kK(true);
            this.kha.bAP().setBarBackgroundColorId(R.color.CAM_X0207);
            this.kha.a((BaseActivity) getContext(), bundle);
            this.kha.bBY();
            this.kha.bAP().setId(R.id.topic_editor);
            this.khd = this.kha.cQm().getInputView();
            this.khd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.khc != null) {
                        if (!TopicDetailView.this.khc.dUc()) {
                            TopicDetailView.this.sf(false);
                        }
                        TopicDetailView.this.khc.yY(false);
                    }
                }
            });
        }
    }

    public void sf(boolean z) {
        if (this.khd != null && this.khd.getText() != null) {
            int selectionEnd = this.khd.getSelectionEnd();
            SpannableStringBuilder d = this.khc.d(this.khd.getText());
            if (d != null) {
                this.khc.yY(true);
                this.khd.setText(d);
                if (z && this.khc.dUa() >= 0) {
                    this.khd.requestFocus();
                    this.khd.setSelection(this.khc.dUa());
                } else {
                    this.khd.setSelection(selectionEnd);
                }
                this.khc.yX(this.khc.dUa() >= 0);
            }
        }
    }

    public void cQn() {
        if (bg.checkUpIsLogin(getContext())) {
            this.kha.bCb();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new aq("c13359").dW("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BM(int i) {
        this.khe = i;
        this.kgZ.setVisibility(0);
        if (i == 1) {
            this.kgZ.setText(R.string.topic_detail_pk_support);
            ao.setBackgroundResource(this.kgZ, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.kgZ.setText(R.string.topic_detail_pk_oppose);
            ao.setBackgroundResource(this.kgZ, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.kgZ.setText(R.string.topic_detail_pk_chigua);
            ao.setBackgroundResource(this.kgZ, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.kgZ.setTextColor(-2130706433);
        } else {
            ao.setViewTextColor(this.kgZ, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                Vp();
            } else if (!this.mHasMore) {
                Vp();
            } else {
                Vo();
            }
            if (!StringUtils.isNull(aVar.eNh)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), at.cutChineseAndEnglishWithSuffix(aVar.eNh, 14, StringHelper.STRING_MORE)));
            }
            this.kgU.setData(aVar.kgm);
            this.jHB.addHeaderView(this.kgU);
            this.kgV.setData(aVar.mDataList);
            if (this.mTopicDetailData.kgm.kgr != null) {
                if (this.mTopicDetailData.kgm.kgr.khL.khR) {
                    BM(1);
                } else if (this.mTopicDetailData.kgm.kgr.khM.khR) {
                    BM(2);
                } else {
                    BM(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.kgZ.setVisibility(8);
            }
            this.kgY.setPadding(dimens, 0, 0, 0);
            cQo();
        }
    }

    public void setNextData(int i, boolean z, List<n> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            Vp();
        } else {
            Vo();
        }
        if (i == 0 && list != null && !x.isEmpty(list)) {
            for (n nVar : list) {
                if (nVar instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.a.c) nVar).kgw = this.mTopicDetailData.cQi();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jHB.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRO() {
        this.jHB.setNextPage(null);
    }

    public void Vo() {
        this.mHasMore = true;
        this.jHB.setNextPage(this.gxy);
        this.gxy.startLoadData();
    }

    public void Vp() {
        this.jHB.setNextPage(this.gxy);
        this.gxy.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdb) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jMm && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            bul();
            TiebaStatic.log(new aq("c13364").dW("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void bul() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eNh;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.kgl) ? null : Uri.parse(this.mTopicDetailData.kgl);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fsv = true;
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
            cQo();
            ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ao.setBackgroundResource(this.kgX, R.color.CAM_X0207);
            ao.setViewTextColor(this.kgY, R.color.CAM_X0109);
            this.kgY.setBackgroundDrawable(ao.aO(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
            BM(this.khe);
            SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jMm != null) {
                SvgManager.bsx().a(this.jMm, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gxx != null) {
                this.gxx.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gGD != null) {
                this.gGD.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kha != null && this.kha.bAP() != null) {
                this.kha.bAP().onChangeSkinType(this.mSkinType);
            }
            if (this.gxy != null) {
                this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gxy.setTextColor(ao.getColor(R.color.CAM_X0110));
                this.gxy.setContainerBackgroundColorResId(ao.getColor(R.color.CAM_X0201));
                this.gxy.setLineColorResource(ao.getColor(R.color.CAM_X0204));
            }
            if (this.kgU != null) {
                this.kgU.onChangeSkinType();
            }
            if (this.kgV != null) {
                this.kgV.notifyDataSetChanged();
            }
            ao.setBackgroundColor(this.jHB, R.color.CAM_X0205);
        }
    }

    public void ip(boolean z) {
        if (!cpB()) {
            if (this.gGD == null) {
                this.gGD = new g(getContext());
                this.gGD.onChangeSkinType();
            }
            this.gGD.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gGD != null) {
            this.gGD.dettachView(this);
            this.gGD = null;
        }
    }

    public boolean cpB() {
        if (this.gGD != null) {
            return this.gGD.isViewAttached();
        }
        return false;
    }

    public void pQ(boolean z) {
        if (!cpC()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.kgT != null) {
                            TopicDetailView.this.kgT.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jHB.setVisibility(8);
            SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Vq() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jHB.setVisibility(0);
        SvgManager.bsx().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cpC() {
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
        this.jHB.setOnSrollToBottomListener(null);
        if (this.gxx != null) {
            this.gxx.b(this.gvp);
        }
        if (this.kha != null) {
            this.kha.onDestory();
        }
        if (this.khg != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.khg);
        }
        hideLoadingView();
        Vq();
    }

    public a getEditor() {
        return this.kha;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.khb != null) {
            ViewGroup.LayoutParams layoutParams = this.khb.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.kha.bAP().isVisible()) {
                    layoutParams2.addRule(2, this.kha.bAP().getId());
                } else {
                    layoutParams2.addRule(2, this.kgW.getId());
                }
                this.khb.setLayoutParams(layoutParams2);
            }
        }
    }

    public void aG(bz bzVar) {
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
            cVar2.kgu = cVar.kgu;
            cVar2.eHK = bzVar;
            cVar2.source = 2;
            cVar2.kgv = this.khe;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.kgw = this.mTopicDetailData.cQi();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.kgV.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQo() {
        if (this.mTopicDetailData != null && this.kgU != null) {
            if (this.khh > this.khi) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cQp()));
                return;
            }
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cQp() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.kgU.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.kgU.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}

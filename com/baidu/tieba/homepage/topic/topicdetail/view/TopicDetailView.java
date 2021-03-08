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
    private BdListView.e Yb;
    private com.baidu.tbadk.editortools.pb.b fFo;
    private NoNetworkView gCe;
    private PbListView gCf;
    private g gLk;
    private NoNetworkView.a gzW;
    private BdTypeRecyclerView jPc;
    private ImageView jVU;
    private View jkF;
    private com.baidu.tieba.write.c krA;
    private EditText krB;
    private int krC;
    private com.baidu.tieba.homepage.topic.topicdetail.model.a krD;
    a.RunnableC0755a krE;
    private int krF;
    private int krG;
    private NewWriteModel.d krH;
    private com.baidu.tieba.homepage.topic.topicdetail.a krr;
    private TopicDetailHeadView krs;
    private com.baidu.tieba.homepage.topic.topicdetail.adapter.b krt;
    private View kru;
    private View krv;
    private TextView krw;
    private TextView krx;
    private a kry;
    private View krz;
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
        this.krv = null;
        this.krw = null;
        this.krx = null;
        this.mHasMore = true;
        this.krF = 0;
        this.krG = 44;
        this.gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                if (z && TopicDetailView.this.mTopicDetailData == null && TopicDetailView.this.krr != null) {
                    TopicDetailView.this.krr.loadData();
                }
            }
        };
        this.fFo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.6
            @Override // com.baidu.tbadk.editortools.pb.b
            public boolean bBO() {
                if (TopicDetailView.this.krA.dWF()) {
                    TopicDetailView.this.mPageContext.showToast(TopicDetailView.this.krA.dWH());
                    TopicDetailView.this.ss(true);
                    return true;
                }
                return false;
            }
        };
        this.krH = new NewWriteModel.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.7
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (z && TopicDetailView.this.kry != null && TopicDetailView.this.kry.bBk() != null) {
                    TopicDetailView.this.kry.bBk().hide();
                }
                if (z) {
                    TopicDetailView.this.krA.Vo(null);
                    TopicDetailView.this.krA.bg(null);
                    TopicDetailView.this.krA.zs(false);
                    if (postWriteCallBackData != null) {
                        long j = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
                        long j2 = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
                        if (j != 0 && j2 != 0) {
                            TopicDetailView.this.krE = TopicDetailView.this.krD.G(j, j2);
                            com.baidu.adp.lib.f.e.mA().postDelayed(TopicDetailView.this.krE, 500L);
                        }
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    TopicDetailView.this.krA.bg(postWriteCallBackData.getSensitiveWords());
                    TopicDetailView.this.krA.Vo(postWriteCallBackData.getErrorString());
                    if (!y.isEmpty(TopicDetailView.this.krA.dWD())) {
                        TopicDetailView.this.ss(true);
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && TopicDetailView.this.kry != null) {
                    TopicDetailView.this.kry.bCt();
                    TopicDetailView.this.setEditorTopViewAboveEditor();
                }
                super.onScrollStateChanged(TopicDetailView.this.jPc, i);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                TopicDetailView.this.krF += i2;
                TopicDetailView.this.cSB();
            }
        };
        this.Yb = new BdListView.e() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.9
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (TopicDetailView.this.mHasMore) {
                    if (!l.isNetOk()) {
                        TopicDetailView.this.bSE();
                        return;
                    }
                    int size = TopicDetailView.this.mTopicDetailData.mDataList.size();
                    if (TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1) instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                        ((TopicDetailActivity) TopicDetailView.this.mPageContext.getPageActivity()).gH(((com.baidu.tieba.homepage.topic.topicdetail.a.c) TopicDetailView.this.mTopicDetailData.mDataList.get(size - 1)).kqS);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.krr = aVar;
        init(bundle);
        onChangeSkinType();
    }

    private void init(Bundle bundle) {
        LayoutInflater.from(getContext()).inflate(R.layout.activity_topic_detail_layout, (ViewGroup) this, true);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.activity_topic_detail_navigation);
        if (this.jkF == null) {
            this.jkF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.jkF.setOnClickListener(this);
            this.mBackImageView = (ImageView) this.jkF.findViewById(R.id.widget_navi_back_button);
        }
        this.jVU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.topic_detail_share_layout, this);
        SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        this.mNavigationBar.mCenterText.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds52));
        this.mNavigationBar.mCenterText.setTypeface(Typeface.defaultFromStyle(1));
        this.gCe = (NoNetworkView) findViewById(R.id.activity_topic_detail_no_network_view);
        this.gCe.a(this.gzW);
        this.krv = findViewById(R.id.pb_editor_tool_comment);
        this.krw = (TextView) findViewById(R.id.topic_editor_tool_comment_reply_text);
        this.krw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetailView.this.cSA();
            }
        });
        this.krx = (TextView) findViewById(R.id.editor_tool_opinion_text_view);
        this.kru = findViewById(R.id.activity_topic_detail_editor);
        at(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.kry.bBk(), layoutParams);
        this.krA = new com.baidu.tieba.write.c();
        this.krz = findViewById(R.id.activity_topic_detail_editor_top);
        this.jPc = (BdTypeRecyclerView) findViewById(R.id.activity_topic_detail_list);
        this.jPc.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jPc.setFadingEdgeLength(0);
        this.jPc.setOverScrollMode(2);
        this.jPc.setOnSrollToBottomListener(this.Yb);
        this.jPc.addOnScrollListener(this.mScrollListener);
        ap.setBackgroundColor(this.jPc, R.color.CAM_X0201);
        this.krt = new com.baidu.tieba.homepage.topic.topicdetail.adapter.b(this.mPageContext, this.jPc);
        this.krs = new TopicDetailHeadView(getContext());
        this.krs.krp.setPkClickListener(new TopicPkView.b() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.4
            @Override // com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.b
            public void Ch(int i) {
                TopicDetailView.this.Cg(i);
            }
        });
        if (this.gLk == null) {
            this.gCf = new PbListView(this.mPageContext.getPageActivity());
            this.gCf.getView();
        }
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds182));
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0110));
        this.gCf.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
        this.gCf.setLineColorResource(ap.getColor(R.color.CAM_X0204));
        this.gCf.setText(getResources().getString(R.string.list_has_no_more));
        this.gCf.getView().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.krD == null) {
            this.krD = new com.baidu.tieba.homepage.topic.topicdetail.model.a(this);
            this.krD.l(this.mPageContext.getUniqueId());
        }
    }

    private void at(Bundle bundle) {
        this.kry = (a) new b().ff(getContext());
        if (this.kry != null) {
            this.kry.a(this.mPageContext);
            this.kry.b(this.krH);
            this.kry.a(this.fFo);
            this.kry.bBk().kN(true);
            this.kry.bBk().setBarBackgroundColorId(R.color.CAM_X0207);
            this.kry.a((BaseActivity) getContext(), bundle);
            this.kry.bCt();
            this.kry.bBk().setId(R.id.topic_editor);
            this.krB = this.kry.cSz().getInputView();
            this.krB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.5
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TopicDetailView.this.krA != null) {
                        if (!TopicDetailView.this.krA.dWG()) {
                            TopicDetailView.this.ss(false);
                        }
                        TopicDetailView.this.krA.zt(false);
                    }
                }
            });
        }
    }

    public void ss(boolean z) {
        if (this.krB != null && this.krB.getText() != null) {
            int selectionEnd = this.krB.getSelectionEnd();
            SpannableStringBuilder d = this.krA.d(this.krB.getText());
            if (d != null) {
                this.krA.zt(true);
                this.krB.setText(d);
                if (z && this.krA.dWE() >= 0) {
                    this.krB.requestFocus();
                    this.krB.setSelection(this.krA.dWE());
                } else {
                    this.krB.setSelection(selectionEnd);
                }
                this.krA.zs(this.krA.dWE() >= 0);
            }
        }
    }

    public void cSA() {
        if (bh.checkUpIsLogin(getContext())) {
            this.kry.bCw();
            setEditorTopViewAboveEditor();
        }
        if (this.mTopicDetailData != null) {
            TiebaStatic.log(new ar("c13359").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg(int i) {
        this.krC = i;
        this.krx.setVisibility(0);
        if (i == 1) {
            this.krx.setText(R.string.topic_detail_pk_support);
            ap.setBackgroundResource(this.krx, R.drawable.topic_discuss_support_bg);
        } else if (i == 2) {
            this.krx.setText(R.string.topic_detail_pk_oppose);
            ap.setBackgroundResource(this.krx, R.drawable.topic_discuss_oppose_bg);
        } else {
            this.krx.setText(R.string.topic_detail_pk_chigua);
            ap.setBackgroundResource(this.krx, R.drawable.topic_discuss_opinion_bg);
        }
        if (this.mSkinType == 1 || this.mSkinType == 4) {
            this.krx.setTextColor(-2130706433);
        } else {
            ap.setViewTextColor(this.krx, R.color.CAM_X0101);
        }
    }

    public void setData(com.baidu.tieba.homepage.topic.topicdetail.a.a aVar) {
        int dimens;
        if (aVar != null) {
            this.mTopicDetailData = aVar;
            this.mHasMore = this.mTopicDetailData.hasMore;
            if (this.mHasMore && this.mTopicDetailData.mDataList.size() <= 4) {
                this.mHasMore = false;
                Xb();
            } else if (!this.mHasMore) {
                Xb();
            } else {
                Xa();
            }
            if (!StringUtils.isNull(aVar.eQU)) {
                this.mNavigationBar.setCenterTextTitle(String.format(getContext().getString(R.string.daily_topic_name), au.cutChineseAndEnglishWithSuffix(aVar.eQU, 14, StringHelper.STRING_MORE)));
            }
            this.krs.setData(aVar.kqK);
            this.jPc.addHeaderView(this.krs);
            this.krt.setData(aVar.mDataList);
            if (this.mTopicDetailData.kqK.kqP != null) {
                if (this.mTopicDetailData.kqK.kqP.ksj.ksp) {
                    Cg(1);
                } else if (this.mTopicDetailData.kqK.kqP.ksk.ksp) {
                    Cg(2);
                } else {
                    Cg(0);
                }
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds140);
            } else {
                dimens = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds50);
                this.krx.setVisibility(8);
            }
            this.krw.setPadding(dimens, 0, 0, 0);
            cSB();
        }
    }

    public void setNextData(int i, boolean z, List<n> list) {
        this.mHasMore = z;
        if (!this.mHasMore) {
            Xb();
        } else {
            Xa();
        }
        if (i == 0 && list != null && !y.isEmpty(list)) {
            for (n nVar : list) {
                if (nVar instanceof com.baidu.tieba.homepage.topic.topicdetail.a.c) {
                    ((com.baidu.tieba.homepage.topic.topicdetail.a.c) nVar).kqU = this.mTopicDetailData.cSv();
                }
            }
            this.mTopicDetailData.mDataList.addAll(list);
            this.jPc.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        this.jPc.setNextPage(null);
    }

    public void Xa() {
        this.mHasMore = true;
        this.jPc.setNextPage(this.gCf);
        this.gCf.startLoadData();
    }

    public void Xb() {
        this.jPc.setNextPage(this.gCf);
        this.gCf.endLoadData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jkF) {
            this.mPageContext.getPageActivity().finish();
        } else if (view == this.jVU && this.mTopicDetailData != null && this.mTopicDetailData.topicId > 0) {
            buI();
            TiebaStatic.log(new ar("c13364").dR("topic_id", String.valueOf(this.mTopicDetailData.topicId)));
        }
    }

    private void buI() {
        if (this.mTopicDetailData != null && getContext() != null) {
            String valueOf = String.valueOf(this.mTopicDetailData.topicId);
            String str = this.mTopicDetailData.eQU;
            String str2 = this.mTopicDetailData.shareTitle;
            if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(str)) {
                this.mPageContext.showToast(getContext().getString(R.string.no_hot_topic_data));
                return;
            }
            String str3 = "http://tieba.baidu.com/mo/q/newtopic/detail?topic_id=" + valueOf + "/";
            Uri parse = StringUtils.isNull(this.mTopicDetailData.kqJ) ? null : Uri.parse(this.mTopicDetailData.kqJ);
            final ShareItem shareItem = new ShareItem();
            shareItem.title = str;
            shareItem.content = str2;
            shareItem.linkUrl = str3;
            shareItem.fwm = true;
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
            cSB();
            ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
            ap.setBackgroundResource(this.krv, R.color.CAM_X0207);
            ap.setViewTextColor(this.krw, R.color.CAM_X0109);
            this.krw.setBackgroundDrawable(ap.aL(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
            Cg(this.krC);
            SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (this.jVU != null) {
                SvgManager.bsU().a(this.jVU, R.drawable.icon_pure_topbar_share44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (this.mPageContext != null && this.gCe != null) {
                this.gCe.onChangeSkinType(this.mPageContext, this.mSkinType);
            }
            if (this.gLk != null) {
                this.gLk.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.kry != null && this.kry.bBk() != null) {
                this.kry.bBk().onChangeSkinType(this.mSkinType);
            }
            if (this.gCf != null) {
                this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
                this.gCf.setTextColor(ap.getColor(R.color.CAM_X0110));
                this.gCf.setContainerBackgroundColorResId(ap.getColor(R.color.CAM_X0201));
                this.gCf.setLineColorResource(ap.getColor(R.color.CAM_X0204));
            }
            if (this.krs != null) {
                this.krs.onChangeSkinType();
            }
            if (this.krt != null) {
                this.krt.notifyDataSetChanged();
            }
            ap.setBackgroundColor(this.jPc, R.color.CAM_X0205);
        }
    }

    public void ir(boolean z) {
        if (!cqY()) {
            if (this.gLk == null) {
                this.gLk = new g(getContext());
                this.gLk.onChangeSkinType();
            }
            this.gLk.attachView(this, z);
        }
    }

    public void hideLoadingView() {
        if (this.gLk != null) {
            this.gLk.dettachView(this);
            this.gLk = null;
        }
    }

    public boolean cqY() {
        if (this.gLk != null) {
            return this.gLk.isViewAttached();
        }
        return false;
    }

    public void qa(boolean z) {
        if (!cqZ()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately() && TopicDetailView.this.krr != null) {
                            TopicDetailView.this.krr.loadData();
                        }
                    }
                });
            }
            this.mRefreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.tbds506));
            this.mRefreshView.attachView(this, z);
            this.mRefreshView.showRefreshButton();
            this.jPc.setVisibility(8);
            SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void Xc() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this);
            this.mRefreshView = null;
        }
        this.jPc.setVisibility(0);
        SvgManager.bsU().a(this.mBackImageView, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public boolean cqZ() {
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
        this.jPc.setOnSrollToBottomListener(null);
        if (this.gCe != null) {
            this.gCe.b(this.gzW);
        }
        if (this.kry != null) {
            this.kry.onDestory();
        }
        if (this.krE != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.krE);
        }
        hideLoadingView();
        Xc();
    }

    public a getEditor() {
        return this.kry;
    }

    public void setEditorTopViewAboveEditor() {
        if (this.krz != null) {
            ViewGroup.LayoutParams layoutParams = this.krz.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.kry.bBk().isVisible()) {
                    layoutParams2.addRule(2, this.kry.bBk().getId());
                } else {
                    layoutParams2.addRule(2, this.kru.getId());
                }
                this.krz.setLayoutParams(layoutParams2);
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
            cVar2.kqS = cVar.kqS;
            cVar2.eLr = cbVar;
            cVar2.source = 2;
            cVar2.kqT = this.krC;
            cVar2.topicId = this.mTopicDetailData.topicId;
            cVar2.kqU = this.mTopicDetailData.cSv();
            this.mTopicDetailData.mDataList.add(i, cVar2);
            this.krt.setData(this.mTopicDetailData.mDataList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSB() {
        if (this.mTopicDetailData != null && this.krs != null) {
            if (this.krF > this.krG) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(cSC()));
                return;
            }
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.transparent);
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        }
    }

    public Bitmap cSC() {
        Bitmap drawingCache;
        com.baidu.adp.widget.ImageView.a bdImage = this.krs.getmBgImg().getBdImage();
        if (bdImage != null) {
            drawingCache = bdImage.getRawBitmap();
        } else {
            drawingCache = this.krs.getmBgImg().getDrawingCache();
        }
        int width = this.mPageContext.getPageActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = this.mNavigationBar.getHeight();
        if (drawingCache != null && drawingCache.getWidth() >= width && drawingCache.getHeight() >= height) {
            return Bitmap.createBitmap(drawingCache, 0, 0, width, height);
        }
        return drawingCache;
    }
}

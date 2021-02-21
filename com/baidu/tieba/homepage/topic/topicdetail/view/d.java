package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.a.c> {
    private boolean akO;
    private TextView eIO;
    private TbPageContext eUY;
    private ConstrainImageGroup ixl;
    private com.baidu.tieba.homepage.topic.topicdetail.a.c kpH;
    private ClickableHeaderImageView kpI;
    private ImageView kpJ;
    private TextView kpK;
    private AgreeView kpL;
    private TextView kpM;
    private ImageView kpN;
    private TbRichTextView kpO;
    private RelativeLayout kpP;
    private View kpQ;
    private TbImageView kpR;
    private TextView kpS;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.akO = true;
        this.mSkinType = 3;
        this.eUY = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.kpI = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.kpJ = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.eIO = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.kpK = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.kpO = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.kpO.setClickable(true);
        this.kpO.setTextEllipsize(TextUtils.TruncateAt.END);
        this.kpO.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.kpO.setLayoutStrategy(aVar);
        this.kpP = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.ixl = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.ixl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.r(1.0d);
        this.ixl.setImageProcessor(aVar2);
        this.kpL = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.kpL.btJ();
        this.kpM = (TextView) view.findViewById(R.id.topic_comment_number);
        this.kpN = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.kpQ = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.kpR = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.kpR.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.kpR.setConrers(5);
        this.kpR.setDrawCorner(true);
        this.kpS = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.eIO.setOnClickListener(this);
        this.kpM.setOnClickListener(this);
        this.kpN.setOnClickListener(this);
        this.kpO.setOnClickListener(this);
        this.kpQ.setOnClickListener(this);
        this.kpS.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ixl != null) {
            this.ixl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ixl != null) {
            this.ixl.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.kpH != null) {
            this.mSkinType = i;
            this.kpI.setIsNight(this.mSkinType == 1);
            if (this.kpH.koS) {
                if (this.kpH.koR == 1) {
                    ap.setImageResource(this.kpJ, R.drawable.label_topic_agree_red);
                    this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                } else if (this.kpH.koR == 2) {
                    ap.setImageResource(this.kpJ, R.drawable.label_topic_disagree_blue);
                    this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                } else {
                    ap.setImageResource(this.kpJ, R.drawable.label_topic_eat_black);
                    this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                }
            }
            ap.setViewTextColor(this.eIO, R.color.CAM_X0105);
            ap.setViewTextColor(this.kpK, R.color.CAM_X0109);
            ap.setViewTextColor(this.kpM, R.color.CAM_X0107);
            if (this.kpN != null) {
                SvgManager.bsR().a(this.kpN, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, (SvgManager.SvgResourceStateType) null);
            }
            this.kpL.onChangeSkinType(i);
            this.kpO.setTextColor(ap.getColor(R.color.CAM_X0105));
            ap.d(this.kpQ, l.getDimens(this.eUY.getPageActivity(), R.dimen.tbds6), R.color.CAM_X0209, R.color.cp_bg_line_j_alpha50);
            ap.setViewTextColor(this.kpS, R.color.CAM_X0109);
            this.ixl.onChangeSkinType();
            ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0205);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        String name_show;
        String formatTime;
        int bnH;
        AgreeData bpJ;
        if (cVar != null && cVar.eJQ != null) {
            this.kpH = cVar;
            onChangeSkinType(this.eUY, TbadkCoreApplication.getInst().getSkinType());
            cb cbVar = this.kpH.eJQ;
            PostData bpv = cbVar.bpv();
            if (bpv != null) {
                this.kpI.setPlaceHolder(1);
                if (this.kpH.source == 1) {
                    this.kpI.setData(cbVar, false, true);
                } else {
                    this.kpI.setData(cbVar, false, false);
                }
                this.kpI.setIsRound(true);
                this.kpI.setBorderWidth(2);
                this.kpI.setDrawBorder(true);
                this.kpI.setPageId(this.eUY.getUniqueId());
                if (this.kpH.koS) {
                    this.kpJ.setVisibility(0);
                    if (this.kpH.koR == 1) {
                        this.kpJ.setImageResource(R.drawable.label_topic_agree_red);
                        this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0301));
                    } else if (this.kpH.koR == 2) {
                        this.kpJ.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0302));
                    } else {
                        this.kpJ.setImageResource(R.drawable.label_topic_eat_black);
                        this.kpI.setBorderColor(this.eUY.getPageActivity().getResources().getColor(R.color.CAM_X0106));
                    }
                } else {
                    this.kpJ.setVisibility(8);
                }
                if (this.kpH.source == 1) {
                    name_show = bpv.bnQ().getName_show();
                    formatTime = au.getFormatTime(bpv.getTime());
                    bnH = bpv.dNJ();
                } else {
                    name_show = cbVar.bnQ().getName_show();
                    formatTime = au.getFormatTime(cbVar.getCreateTime());
                    bnH = cbVar.bnH();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.eIO.setText(au.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(cbVar.bnU())) {
                    this.kpK.setText(formatTime);
                } else {
                    this.kpK.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), au.cutChineseAndEnglishWithSuffix(cbVar.bnU(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.bsR().a(this.kpN, R.drawable.icon_pure_topic_reply16_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = au.numFormatOverWan(bnH);
                if (bnH > 0) {
                    this.kpM.setVisibility(0);
                    this.kpM.setText(numFormatOverWan);
                } else {
                    this.kpM.setText(this.eUY.getString(R.string.action_comment_default));
                    this.kpM.setVisibility(0);
                }
                if (this.kpH.source == 1) {
                    bpJ = bpv.bpJ();
                    bpJ.objType = 1;
                } else {
                    bpJ = cbVar.bpJ();
                    bpJ.objType = 3;
                }
                bpJ.threadId = cbVar.getTid();
                this.kpL.setData(bpJ);
                this.kpL.setTopicId(String.valueOf(this.kpH.topicId));
                a(bpv, cbVar);
                a(cVar, cbVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, cb cbVar) {
        if (this.kpH.source == 1) {
            this.kpO.setVisibility(0);
            this.kpO.setText(postData.dNH());
            return;
        }
        List<PbContent> bnG = cbVar.bnG();
        if (y.getCount(bnG) > 0) {
            this.kpO.setVisibility(0);
            this.kpO.setText(TbRichTextView.a(getContext(), bnG, false));
            return;
        }
        SpannableString boM = cbVar.boM();
        if (boM != null && !StringUtils.isNull(boM.toString())) {
            this.kpO.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", boM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.kpO.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.kpO.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar, cb cbVar) {
        if (this.kpH.source == 1) {
            this.kpQ.setVisibility(0);
            this.kpP.setVisibility(8);
            String title = cbVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.kpQ.setVisibility(8);
                return;
            }
            this.kpQ.setVisibility(0);
            this.kpS.setText(title);
            String str = null;
            if (y.getCount(cbVar.bnZ()) != 0 && !y.isEmpty(cVar.eJQ.bnZ())) {
                Iterator<MediaData> it = cVar.eJQ.bnZ().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                ap.setImageResource(this.kpR, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.kpR.setPlaceHolder(1);
            this.kpR.startLoad(str, 10, false);
            return;
        }
        this.kpQ.setVisibility(8);
        this.kpP.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.a.c cVar) {
        final cb cbVar = cVar.eJQ;
        ArrayList<MediaData> bnZ = cbVar.bnZ();
        if (k.bkT().isShowImages() && y.getCount(bnZ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < bnZ.size(); i++) {
                MediaData mediaData = (MediaData) y.getItem(bnZ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (y.getCount(linkedList) > 0) {
                this.kpP.setVisibility(0);
                this.ixl.setFromCDN(this.akO);
                this.ixl.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void c(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, cbVar);
                        } else {
                            d.this.bzk();
                        }
                    }
                });
                this.ixl.setImageMediaList(linkedList);
                return;
            }
            this.kpP.setVisibility(8);
            return;
        }
        this.kpP.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.ixl != null) {
            this.ixl.setPageUniqueId(bdUniqueId);
        }
    }

    public void bzk() {
        if (this.kpH != null && this.kpH.eJQ != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.eUY.getPageActivity()).createFromThreadCfg(this.kpH.eJQ, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.kpH.eJQ.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.kpH.eJQ.bnU());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            m.IN(this.kpH.eJQ.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void cSw() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.eUY.getPageActivity()).createNormalCfg(String.valueOf(this.kpH.eJQ.getTid()), String.format("%1$s", this.kpH.eJQ.bpv().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, cb cbVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.akO ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(cbVar.getTid(), -1L);
                    imageUrlData.postId = mediaData.getPostId();
                    concurrentHashMap.put(mediaData.getSrc_pic(), imageUrlData);
                }
            }
        }
        if (arrayList.size() <= 0) {
            for (MediaData mediaData2 : list) {
                if (!TextUtils.isEmpty(mediaData2.getPicUrl())) {
                    arrayList.add(mediaData2.getPicUrl());
                }
            }
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        ImageViewerConfig.a aVar = new ImageViewerConfig.a();
        aVar.s(arrayList).mQ(i).zJ(cbVar.bnU()).zK(String.valueOf(cbVar.getFid())).zL(cbVar.getTid()).jg(this.akO).zM(arrayList.size() > 0 ? arrayList.get(0) : "").jh(true).d(concurrentHashMap).ji(true).s(cbVar).a(rect, UtilHelper.fixedDrawableRect(rect, view));
        ImageViewerConfig eP = aVar.eP(this.mTbPageContext.getPageActivity());
        if (this.currentPageType == 2) {
            eP.getIntent().putExtra("from", "index");
        } else {
            eP.getIntent().putExtra("from", "other");
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, eP));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = cbVar.getId();
        historyMessage.threadName = cbVar.getTitle();
        historyMessage.forumName = cbVar.bnU();
        historyMessage.postID = cbVar.bog();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kpH != null && this.kpH.eJQ != null) {
            if (view == this.kpO) {
                if (this.kpH.source == 1) {
                    cSw();
                } else {
                    bzk();
                }
                Mi("1");
            }
            if (view == this.kpM || view == this.kpN) {
                if (this.kpH.source == 1) {
                    cSw();
                } else {
                    bzk();
                }
                Mi("3");
            } else if (view == this.eIO) {
                cSx();
            } else {
                bzk();
                Mi("2");
            }
        }
    }

    private void cSx() {
        MetaData bnQ;
        if (this.kpH != null && this.kpH.eJQ != null) {
            cb cbVar = this.kpH.eJQ;
            if (this.kpH.source == 1 && cbVar.bpv() != null) {
                bnQ = cbVar.bpv().bnQ();
            } else {
                bnQ = cbVar.bnQ();
            }
            if (bnQ != null && !StringUtils.isNull(bnQ.getName_show()) && !StringUtils.isNull(bnQ.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(bnQ.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), bnQ.isBigV());
                createNormalConfig.setSourceTid(cbVar.getTid());
                createNormalConfig.setSourceNid(cbVar.bmo());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Mi(String str) {
        TiebaStatic.log(new ar("c13356").dR("obj_locate", str).dR("tid", this.kpH.eJQ.getTid()).v("topic_id", this.kpH.topicId).dR("obj_type", String.valueOf(this.kpH.source)));
    }
}

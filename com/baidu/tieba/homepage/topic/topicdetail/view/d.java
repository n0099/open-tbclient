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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean NK;
    private TbPageContext cVv;
    private TextView cbW;
    private ConstrainImageGroup fKK;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hiM;
    private ClickableHeaderImageView hiN;
    private ImageView hiO;
    private TextView hiP;
    private AgreeView hiQ;
    private TextView hiR;
    private ImageView hiS;
    private TbRichTextView hiT;
    private RelativeLayout hiU;
    private View hiV;
    private TbImageView hiW;
    private TextView hiX;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.NK = true;
        this.mSkinType = 3;
        this.cVv = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hiN = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hiO = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cbW = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hiP = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hiT = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hiT.setClickable(true);
        this.hiT.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hiT.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hiT.setLayoutStrategy(aVar);
        this.hiU = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.fKK = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.fKK.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.fKK.setImageProcessor(aVar2);
        this.hiQ = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hiQ.aHu();
        this.hiR = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hiS = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hiV = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hiW = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hiW.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hiW.setConrers(5);
        this.hiW.setDrawCorner(true);
        this.hiX = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cbW.setOnClickListener(this);
        this.hiR.setOnClickListener(this);
        this.hiS.setOnClickListener(this);
        this.hiT.setOnClickListener(this);
        this.hiV.setOnClickListener(this);
        this.hiX.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fKK != null) {
            this.fKK.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fKK != null) {
            this.fKK.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fKK != null) {
            this.fKK.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hiM != null) {
            this.mSkinType = i;
            this.hiN.setIsNight(this.mSkinType == 1);
            if (this.hiM.hhW) {
                if (this.hiM.hhV == 1) {
                    am.setImageResource(this.hiO, R.drawable.label_topic_agree_red);
                    this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hiM.hhV == 2) {
                    am.setImageResource(this.hiO, R.drawable.label_topic_disagree_blue);
                    this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hiO, R.drawable.label_topic_eat_black);
                    this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.cbW, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hiP, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hiR, (int) R.color.cp_cont_j);
            if (this.hiS != null) {
                SvgManager.aGG().a(this.hiS, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hiQ.onChangeSkinType(i);
            this.hiT.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hiV, l.getDimens(this.cVv.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hiX, (int) R.color.cp_cont_d);
            this.fKK.onChangeSkinType();
            am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_e);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.topic_discuss_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        String name_show;
        String formatTime;
        int aCi;
        AgreeData aEe;
        if (cVar != null && cVar.cRt != null) {
            this.hiM = cVar;
            onChangeSkinType(this.cVv, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hiM.cRt;
            PostData aDQ = bjVar.aDQ();
            if (aDQ != null) {
                this.hiN.setPlaceHolder(1);
                if (this.hiM.source == 1) {
                    this.hiN.setData(bjVar, false, true);
                } else {
                    this.hiN.setData(bjVar, false, false);
                }
                this.hiN.setIsRound(true);
                this.hiN.setBorderWidth(2);
                this.hiN.setDrawBorder(true);
                this.hiN.setPageId(this.cVv.getUniqueId());
                if (this.hiM.hhW) {
                    this.hiO.setVisibility(0);
                    if (this.hiM.hhV == 1) {
                        this.hiO.setImageResource(R.drawable.label_topic_agree_red);
                        this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hiM.hhV == 2) {
                        this.hiO.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hiO.setImageResource(R.drawable.label_topic_eat_black);
                        this.hiN.setBorderColor(this.cVv.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hiO.setVisibility(8);
                }
                if (this.hiM.source == 1) {
                    name_show = aDQ.aCr().getName_show();
                    formatTime = aq.getFormatTime(aDQ.getTime());
                    aCi = aDQ.cLz();
                } else {
                    name_show = bjVar.aCr().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    aCi = bjVar.aCi();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cbW.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aCw())) {
                    this.hiP.setText(formatTime);
                } else {
                    this.hiP.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aCw(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aGG().a(this.hiS, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aCi);
                if (aCi > 0) {
                    this.hiR.setVisibility(0);
                    this.hiR.setText(numFormatOverWan);
                } else {
                    this.hiR.setText(this.cVv.getString(R.string.action_comment_default));
                    this.hiR.setVisibility(0);
                }
                if (this.hiM.source == 1) {
                    aEe = aDQ.aEe();
                    aEe.objType = 1;
                } else {
                    aEe = bjVar.aEe();
                    aEe.objType = 3;
                }
                aEe.threadId = bjVar.getTid();
                this.hiQ.setData(aEe);
                this.hiQ.setTopicId(String.valueOf(this.hiM.topicId));
                a(aDQ, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hiM.source == 1) {
            this.hiT.setVisibility(0);
            this.hiT.setText(postData.cLx());
            return;
        }
        List<PbContent> aCh = bjVar.aCh();
        if (v.getCount(aCh) > 0) {
            this.hiT.setVisibility(0);
            this.hiT.setText(TbRichTextView.a(getContext(), aCh, false));
            return;
        }
        SpannableString aDj = bjVar.aDj();
        if (aDj != null && !StringUtils.isNull(aDj.toString())) {
            this.hiT.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aDj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hiT.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hiT.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hiM.source == 1) {
            this.hiV.setVisibility(0);
            this.hiU.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hiV.setVisibility(8);
                return;
            }
            this.hiV.setVisibility(0);
            this.hiX.setText(title);
            String str = null;
            if (v.getCount(bjVar.aCB()) != 0 && !v.isEmpty(cVar.cRt.aCB())) {
                Iterator<MediaData> it = cVar.cRt.aCB().iterator();
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
                am.setImageResource(this.hiW, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hiW.setPlaceHolder(1);
            this.hiW.startLoad(str, 10, false);
            return;
        }
        this.hiV.setVisibility(8);
        this.hiU.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.cRt;
        ArrayList<MediaData> aCB = bjVar.aCB();
        if (i.azR().isShowImages() && v.getCount(aCB) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCB.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCB, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hiU.setVisibility(0);
                this.fKK.setFromCDN(this.NK);
                this.fKK.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aMD();
                        }
                    }
                });
                this.fKK.setImageMediaList(linkedList);
                return;
            }
            this.hiU.setVisibility(8);
            return;
        }
        this.hiU.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fKK != null) {
            this.fKK.setPageUniqueId(bdUniqueId);
        }
    }

    public void aMD() {
        if (this.hiM != null && this.hiM.cRt != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVv.getPageActivity()).createFromThreadCfg(this.hiM.cRt, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hiM.cRt.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hiM.cRt.aCw());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.zV(this.hiM.cRt.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bPT() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cVv.getPageActivity()).createNormalCfg(String.valueOf(this.hiM.cRt.getTid()), String.format("%1$s", this.hiM.cRt.aDQ().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setJumpToCommentArea(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bj bjVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
            l.showToast(this.mTbPageContext.getPageActivity(), (int) R.string.plugin_image_viewer_install_error_tips);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (MediaData mediaData : list) {
            if (!TextUtils.isEmpty(mediaData.getSrc_pic())) {
                arrayList.add(mediaData.getSrc_pic());
                if (!TextUtils.isEmpty(mediaData.getPicUrl())) {
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = this.NK ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.f.b.toLong(bjVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCw(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NK, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        createConfig.setThreadData(bjVar);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bjVar.getId();
        historyMessage.threadName = bjVar.getTitle();
        historyMessage.forumName = bjVar.aCw();
        historyMessage.postID = bjVar.aCH();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hiM != null && this.hiM.cRt != null) {
            if (view == this.hiT) {
                if (this.hiM.source == 1) {
                    bPT();
                } else {
                    aMD();
                }
                Cm("1");
            }
            if (view == this.hiR || view == this.hiS) {
                if (this.hiM.source == 1) {
                    bPT();
                } else {
                    aMD();
                }
                Cm("3");
            } else if (view == this.cbW) {
                bPU();
            } else {
                aMD();
                Cm("2");
            }
        }
    }

    private void bPU() {
        MetaData aCr;
        if (this.hiM != null && this.hiM.cRt != null) {
            bj bjVar = this.hiM.cRt;
            if (this.hiM.source == 1 && bjVar.aDQ() != null) {
                aCr = bjVar.aDQ().aCr();
            } else {
                aCr = bjVar.aCr();
            }
            if (aCr != null && !StringUtils.isNull(aCr.getName_show()) && !StringUtils.isNull(aCr.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aCr.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCr.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Cm(String str) {
        TiebaStatic.log(new an("c13356").cx("obj_locate", str).cx("tid", this.hiM.cRt.getTid()).s("topic_id", this.hiM.topicId).cx("obj_type", String.valueOf(this.hiM.source)));
    }
}

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
    private boolean NJ;
    private TbPageContext cVg;
    private TextView cbJ;
    private ConstrainImageGroup fJN;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c hgX;
    private ClickableHeaderImageView hgY;
    private ImageView hgZ;
    private TextView hha;
    private AgreeView hhb;
    private TextView hhc;
    private ImageView hhd;
    private TbRichTextView hhe;
    private RelativeLayout hhf;
    private View hhg;
    private TbImageView hhh;
    private TextView hhi;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.NJ = true;
        this.mSkinType = 3;
        this.cVg = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hgY = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.hgZ = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cbJ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.hha = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.hhe = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.hhe.setClickable(true);
        this.hhe.setTextEllipsize(TextUtils.TruncateAt.END);
        this.hhe.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.hhe.setLayoutStrategy(aVar);
        this.hhf = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.fJN = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.fJN.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.fJN.setImageProcessor(aVar2);
        this.hhb = (AgreeView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.hhb.aHn();
        this.hhc = (TextView) view.findViewById(R.id.topic_comment_number);
        this.hhd = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.hhg = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.hhh = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.hhh.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.hhh.setConrers(5);
        this.hhh.setDrawCorner(true);
        this.hhi = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cbJ.setOnClickListener(this);
        this.hhc.setOnClickListener(this);
        this.hhd.setOnClickListener(this);
        this.hhe.setOnClickListener(this);
        this.hhg.setOnClickListener(this);
        this.hhi.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.fJN != null) {
            this.fJN.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.fJN != null) {
            this.fJN.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.fJN != null) {
            this.fJN.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.hgX != null) {
            this.mSkinType = i;
            this.hgY.setIsNight(this.mSkinType == 1);
            if (this.hgX.hgi) {
                if (this.hgX.hgh == 1) {
                    am.setImageResource(this.hgZ, R.drawable.label_topic_agree_red);
                    this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.hgX.hgh == 2) {
                    am.setImageResource(this.hgZ, R.drawable.label_topic_disagree_blue);
                    this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.hgZ, R.drawable.label_topic_eat_black);
                    this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.cbJ, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hha, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.hhc, (int) R.color.cp_cont_j);
            if (this.hhd != null) {
                SvgManager.aGA().a(this.hhd, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, (SvgManager.SvgResourceStateType) null);
            }
            this.hhb.onChangeSkinType(i);
            this.hhe.setTextColor(am.getColor(R.color.cp_cont_b));
            am.c(this.hhg, l.getDimens(this.cVg.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.hhi, (int) R.color.cp_cont_d);
            this.fJN.onChangeSkinType();
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
        int aCd;
        AgreeData aDY;
        if (cVar != null && cVar.cRe != null) {
            this.hgX = cVar;
            onChangeSkinType(this.cVg, TbadkCoreApplication.getInst().getSkinType());
            bj bjVar = this.hgX.cRe;
            PostData aDK = bjVar.aDK();
            if (aDK != null) {
                this.hgY.setPlaceHolder(1);
                if (this.hgX.source == 1) {
                    this.hgY.setData(bjVar, false, true);
                } else {
                    this.hgY.setData(bjVar, false, false);
                }
                this.hgY.setIsRound(true);
                this.hgY.setBorderWidth(2);
                this.hgY.setDrawBorder(true);
                this.hgY.setPageId(this.cVg.getUniqueId());
                if (this.hgX.hgi) {
                    this.hgZ.setVisibility(0);
                    if (this.hgX.hgh == 1) {
                        this.hgZ.setImageResource(R.drawable.label_topic_agree_red);
                        this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.hgX.hgh == 2) {
                        this.hgZ.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.hgZ.setImageResource(R.drawable.label_topic_eat_black);
                        this.hgY.setBorderColor(this.cVg.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.hgZ.setVisibility(8);
                }
                if (this.hgX.source == 1) {
                    name_show = aDK.aCm().getName_show();
                    formatTime = aq.getFormatTime(aDK.getTime());
                    aCd = aDK.cLc();
                } else {
                    name_show = bjVar.aCm().getName_show();
                    formatTime = aq.getFormatTime(bjVar.getCreateTime());
                    aCd = bjVar.aCd();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cbJ.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bjVar.aCr())) {
                    this.hha.setText(formatTime);
                } else {
                    this.hha.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bjVar.aCr(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.aGA().a(this.hhd, R.drawable.icon_pure_topic_reply16_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aCd);
                if (aCd > 0) {
                    this.hhc.setVisibility(0);
                    this.hhc.setText(numFormatOverWan);
                } else {
                    this.hhc.setText(this.cVg.getString(R.string.action_comment_default));
                    this.hhc.setVisibility(0);
                }
                if (this.hgX.source == 1) {
                    aDY = aDK.aDY();
                    aDY.objType = 1;
                } else {
                    aDY = bjVar.aDY();
                    aDY.objType = 3;
                }
                aDY.threadId = bjVar.getTid();
                this.hhb.setData(aDY);
                this.hhb.setTopicId(String.valueOf(this.hgX.topicId));
                a(aDK, bjVar);
                a(cVar, bjVar);
                setPageUniqueId(getTag());
            }
        }
    }

    private void a(PostData postData, bj bjVar) {
        if (this.hgX.source == 1) {
            this.hhe.setVisibility(0);
            this.hhe.setText(postData.cLa());
            return;
        }
        List<PbContent> aCc = bjVar.aCc();
        if (v.getCount(aCc) > 0) {
            this.hhe.setVisibility(0);
            this.hhe.setText(TbRichTextView.a(getContext(), aCc, false));
            return;
        }
        SpannableString aDe = bjVar.aDe();
        if (aDe != null && !StringUtils.isNull(aDe.toString())) {
            this.hhe.setVisibility(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "0");
                jSONObject.put("text", aDe);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            this.hhe.setText(TbRichTextView.a(getContext(), jSONArray, false));
            return;
        }
        this.hhe.setVisibility(8);
    }

    private void a(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar, bj bjVar) {
        if (this.hgX.source == 1) {
            this.hhg.setVisibility(0);
            this.hhf.setVisibility(8);
            String title = bjVar.getTitle();
            if (StringUtils.isNull(title)) {
                this.hhg.setVisibility(8);
                return;
            }
            this.hhg.setVisibility(0);
            this.hhi.setText(title);
            String str = null;
            if (v.getCount(bjVar.aCw()) != 0 && !v.isEmpty(cVar.cRe.aCw())) {
                Iterator<MediaData> it = cVar.cRe.aCw().iterator();
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
                am.setImageResource(this.hhh, R.drawable.pic_frs_topic_shareinone);
                return;
            }
            this.hhh.setPlaceHolder(1);
            this.hhh.startLoad(str, 10, false);
            return;
        }
        this.hhg.setVisibility(8);
        this.hhf.setVisibility(0);
        b(cVar);
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bj bjVar = cVar.cRe;
        ArrayList<MediaData> aCw = bjVar.aCw();
        if (i.azM().isShowImages() && v.getCount(aCw) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aCw.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aCw, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.hhf.setVisibility(0);
                this.fJN.setFromCDN(this.NJ);
                this.fJN.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bjVar);
                        } else {
                            d.this.aMw();
                        }
                    }
                });
                this.fJN.setImageMediaList(linkedList);
                return;
            }
            this.hhf.setVisibility(8);
            return;
        }
        this.hhf.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.fJN != null) {
            this.fJN.setPageUniqueId(bdUniqueId);
        }
    }

    public void aMw() {
        if (this.hgX != null && this.hgX.cRe != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cVg.getPageActivity()).createFromThreadCfg(this.hgX.cRe, null, "none", RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.hgX.cRe.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.hgX.cRe.aCr());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            addLocateParam.setJumpToCommentArea(true);
            com.baidu.tieba.card.l.zS(this.hgX.cRe.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bPy() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cVg.getPageActivity()).createNormalCfg(String.valueOf(this.hgX.cRe.getTid()), String.format("%1$s", this.hgX.cRe.aDK().getId()) + "", 1, "mention");
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
                    imageUrlData.urlType = this.NJ ? 13 : 14;
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bjVar.aCr(), String.valueOf(bjVar.getFid()), bjVar.getTid(), this.NJ, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.forumName = bjVar.aCr();
        historyMessage.postID = bjVar.aCC();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hgX != null && this.hgX.cRe != null) {
            if (view == this.hhe) {
                if (this.hgX.source == 1) {
                    bPy();
                } else {
                    aMw();
                }
                Cl("1");
            }
            if (view == this.hhc || view == this.hhd) {
                if (this.hgX.source == 1) {
                    bPy();
                } else {
                    aMw();
                }
                Cl("3");
            } else if (view == this.cbJ) {
                bPz();
            } else {
                aMw();
                Cl("2");
            }
        }
    }

    private void bPz() {
        MetaData aCm;
        if (this.hgX != null && this.hgX.cRe != null) {
            bj bjVar = this.hgX.cRe;
            if (this.hgX.source == 1 && bjVar.aDK() != null) {
                aCm = bjVar.aDK().aCm();
            } else {
                aCm = bjVar.aCm();
            }
            if (aCm != null && !StringUtils.isNull(aCm.getName_show()) && !StringUtils.isNull(aCm.getUserId())) {
                long j = com.baidu.adp.lib.f.b.toLong(aCm.getUserId(), 0L);
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, j == com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), aCm.isBigV());
                createNormalConfig.setSourceTid(bjVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void Cl(String str) {
        TiebaStatic.log(new an("c13356").cy("obj_locate", str).cy("tid", this.hgX.cRe.getTid()).s("topic_id", this.hgX.topicId).cy("obj_type", String.valueOf(this.hgX.source)));
    }
}

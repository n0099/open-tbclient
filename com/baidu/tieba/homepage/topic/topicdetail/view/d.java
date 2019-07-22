package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.AgreeAloneView;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.c> {
    private boolean Yd;
    private int cbI;
    private TextView ccZ;
    private ConstrainImageGroup eCM;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c gmC;
    private ClickableHeaderImageView gmD;
    private ImageView gmE;
    private TextView gmF;
    private AgreeAloneView gmG;
    private TextView gmH;
    private ImageView gmI;
    private TbRichTextView gmJ;
    private RelativeLayout gmK;
    private View gmL;
    private TbImageView gmM;
    private TextView gmN;
    private View mBottomLine;
    private TbPageContext mContext;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.Yd = true;
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.cbI = R.drawable.selector_topic_detail_comment_icon;
        this.gmD = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.gmE = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.ccZ = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.gmF = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.gmJ = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.gmJ.setClickable(true);
        this.gmJ.getLayoutStrategy().setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.gmJ.setTextEllipsize(TextUtils.TruncateAt.END);
        this.gmJ.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.g(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.gmJ.setLayoutStrategy(aVar);
        this.gmK = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.eCM = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.eCM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.eCM.setImageProcessor(aVar2);
        this.gmG = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.gmH = (TextView) view.findViewById(R.id.topic_comment_number);
        this.gmI = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.gmL = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.gmM = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.gmM.setRadius(l.g(getContext(), R.dimen.tbds6));
        this.gmM.setConrers(5);
        this.gmM.setDrawCorner(true);
        this.gmN = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.ccZ.setOnClickListener(this);
        this.gmH.setOnClickListener(this);
        this.gmI.setOnClickListener(this);
        this.gmJ.setOnClickListener(this);
        this.gmL.setOnClickListener(this);
        this.gmN.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCM != null) {
            this.eCM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCM != null) {
            this.eCM.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCM != null) {
            this.eCM.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.gmC != null) {
            this.mSkinType = i;
            this.gmD.setIsNight(this.mSkinType == 1);
            if (this.gmC.glM) {
                if (this.gmC.glL == 1) {
                    am.c(this.gmE, (int) R.drawable.label_topic_agree_red);
                    this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.gmC.glL == 2) {
                    am.c(this.gmE, (int) R.drawable.label_topic_disagree_blue);
                    this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.c(this.gmE, (int) R.drawable.label_topic_eat_black);
                    this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.j(this.ccZ, R.color.cp_cont_b);
            am.j(this.gmF, R.color.cp_cont_d);
            am.j(this.gmH, R.drawable.selector_topic_detail_comment_text_color);
            if (this.gmI != null && this.cbI > 0) {
                this.gmI.setImageDrawable(am.getDrawable(this.cbI));
            }
            this.gmG.onChangeSkinType(i);
            this.gmJ.setTextColor(am.getColor(R.color.cp_cont_b));
            am.k(this.gmL, R.drawable.topic_original_bg_corner);
            am.j(this.gmN, R.color.cp_cont_d);
            this.eCM.onChangeSkinType();
            am.l(this.mBottomLine, R.color.cp_bg_line_c);
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
        String aD;
        int aeo;
        AgreeData agn;
        if (cVar != null && cVar.threadData != null) {
            this.gmC = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bg bgVar = this.gmC.threadData;
            PostData afV = bgVar.afV();
            if (afV != null) {
                if (this.gmC.source == 1) {
                    this.gmD.setData(bgVar, false, true);
                } else {
                    this.gmD.setData(bgVar, false, false);
                }
                this.gmD.setDefaultResource(R.drawable.icon_default_avatar100);
                this.gmD.setDefaultBgResource(R.color.cp_bg_line_e);
                this.gmD.setIsRound(true);
                this.gmD.setBorderWidth(2);
                this.gmD.setDrawBorder(true);
                this.gmD.setPageId(this.mContext.getUniqueId());
                if (this.gmC.glM) {
                    this.gmE.setVisibility(0);
                    if (this.gmC.glL == 1) {
                        this.gmE.setImageResource(R.drawable.label_topic_agree_red);
                        this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.gmC.glL == 2) {
                        this.gmE.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.gmE.setImageResource(R.drawable.label_topic_eat_black);
                        this.gmD.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.gmE.setVisibility(8);
                }
                if (this.gmC.source == 1) {
                    name_show = afV.aex().getName_show();
                    aD = aq.aD(afV.getTime());
                    aeo = afV.cpt();
                } else {
                    name_show = bgVar.aex().getName_show();
                    aD = aq.aD(bgVar.getCreateTime());
                    aeo = bgVar.aeo();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.ccZ.setText(aq.j(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bgVar.aeC())) {
                    this.gmF.setText(aD);
                } else {
                    this.gmF.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.j(bgVar.aeC(), 10, "..."), aD));
                }
                this.gmI.setImageDrawable(am.getDrawable(this.cbI));
                String aO = aq.aO(aeo);
                if (aeo > 0) {
                    this.gmH.setVisibility(0);
                    this.gmH.setText(aO);
                } else {
                    this.gmH.setText(this.mContext.getString(R.string.action_comment_default));
                    this.gmH.setVisibility(0);
                }
                if (this.gmC.source == 1) {
                    agn = afV.agn();
                    agn.objType = 1;
                } else {
                    agn = bgVar.agn();
                    agn.objType = 3;
                }
                agn.threadId = bgVar.getTid();
                this.gmG.setData(agn);
                this.gmG.setTopicId(String.valueOf(this.gmC.topicId));
                if (this.gmC.source == 1) {
                    this.gmJ.setVisibility(0);
                    this.gmJ.setText(afV.cpr());
                } else {
                    this.gmJ.setVisibility(0);
                    int size = bgVar.aen().size();
                    if (StringUtils.isNull(bgVar.afY().toString()) && size <= 0) {
                        this.gmJ.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bgVar.aen(), false);
                        if (a != null) {
                            this.gmJ.setText(a);
                        }
                    } else if (!StringUtils.isNull(bgVar.afY().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bgVar.afY().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.gmJ.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.gmJ.setVisibility(8);
                    }
                }
                if (this.gmC.source == 1) {
                    this.gmL.setVisibility(0);
                    this.gmK.setVisibility(8);
                    ArrayList<MediaData> aeH = bgVar.aeH();
                    String str = null;
                    String title = bgVar.getTitle();
                    if (v.Z(aeH) != 0 && !v.aa(cVar.threadData.aeH())) {
                        Iterator<MediaData> it = cVar.threadData.aeH().iterator();
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
                    if (StringUtils.isNull(title)) {
                        this.gmL.setVisibility(8);
                    } else {
                        this.gmL.setVisibility(0);
                        this.gmN.setText(title);
                        if (StringUtils.isNull(str)) {
                            am.c(this.gmM, (int) R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.gmM.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.gmL.setVisibility(8);
                    this.gmK.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bg bgVar = cVar.threadData;
        ArrayList<MediaData> aeH = bgVar.aeH();
        if (i.aca().ace() && v.Z(aeH) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeH.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeH, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.gmK.setVisibility(0);
                this.eCM.setFromCDN(this.Yd);
                this.eCM.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bgVar);
                        } else {
                            d.this.aqb();
                        }
                    }
                });
                this.eCM.setImageMediaList(linkedList);
                return;
            }
            this.gmK.setVisibility(8);
            return;
        }
        this.gmK.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eCM != null) {
            this.eCM.setPageUniqueId(bdUniqueId);
        }
    }

    public void aqb() {
        if (this.gmC != null && this.gmC.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.gmC.threadData, null, "none", 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.gmC.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gmC.threadData.aeC());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.vw(this.gmC.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bxw() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.gmC.threadData.getTid()), String.format("%1$s", this.gmC.threadData.afV().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bg bgVar) {
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
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
                    imageUrlData.urlType = this.Yd ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bgVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bgVar.aeC(), String.valueOf(bgVar.getFid()), bgVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", ImageViewerConfig.FROM_OTHER);
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bgVar.getId();
        historyMessage.threadName = bgVar.getTitle();
        historyMessage.forumName = bgVar.aeC();
        historyMessage.postID = bgVar.aeN();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gmC != null && this.gmC.threadData != null) {
            if (view == this.gmJ) {
                if (this.gmC.source == 1) {
                    bxw();
                } else {
                    aqb();
                }
                yj("1");
            }
            if (view == this.gmH || view == this.gmI) {
                if (this.gmC.source == 1) {
                    bxw();
                } else {
                    aqb();
                }
                yj("3");
            } else if (view == this.ccZ) {
                bxx();
            } else {
                aqb();
                yj("2");
            }
        }
    }

    private void bxx() {
        MetaData aex;
        if (this.gmC != null && this.gmC.threadData != null) {
            bg bgVar = this.gmC.threadData;
            if (this.gmC.source == 1 && bgVar.afV() != null) {
                aex = bgVar.afV().aex();
            } else {
                aex = bgVar.aex();
            }
            if (aex != null && !StringUtils.isNull(aex.getName_show()) && !StringUtils.isNull(aex.getUserId())) {
                long c = com.baidu.adp.lib.g.b.c(aex.getUserId(), 0L);
                boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (bgVar.afH() != null && bgVar.afH().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(getContext(), bgVar.afH().channelId, bgVar.afH().mCurrentPage)));
                    return;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(c, z, aex.isBigV());
                createNormalConfig.setSourceTid(bgVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            }
        }
    }

    private void yj(String str) {
        TiebaStatic.log(new an("c13356").bT("obj_locate", str).bT("tid", this.gmC.threadData.getTid()).l("topic_id", this.gmC.topicId).bT("obj_type", String.valueOf(this.gmC.source)));
    }
}

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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
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
    private boolean HY;
    private TbPageContext cfl;
    private TextView csn;
    private ConstrainImageGroup eNi;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c goK;
    private ClickableHeaderImageView goL;
    private ImageView goM;
    private TextView goN;
    private AgreeAloneView goO;
    private TextView goP;
    private ImageView goQ;
    private TbRichTextView goR;
    private RelativeLayout goS;
    private View goT;
    private TbImageView goU;
    private TextView goV;
    private View mBottomLine;
    private int mSkinType;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.HY = true;
        this.mSkinType = 3;
        this.cfl = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.goL = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.goM = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.csn = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.goN = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.goR = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.goR.setClickable(true);
        this.goR.getLayoutStrategy().setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.goR.setTextEllipsize(TextUtils.TruncateAt.END);
        this.goR.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.getDimens(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.goR.setLayoutStrategy(aVar);
        this.goS = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.eNi = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.eNi.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.g(1.0d);
        this.eNi.setImageProcessor(aVar2);
        this.goO = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.goP = (TextView) view.findViewById(R.id.topic_comment_number);
        this.goQ = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.goT = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.goU = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.goU.setRadius(l.getDimens(getContext(), R.dimen.tbds6));
        this.goU.setConrers(5);
        this.goU.setDrawCorner(true);
        this.goV = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.csn.setOnClickListener(this);
        this.goP.setOnClickListener(this);
        this.goQ.setOnClickListener(this);
        this.goR.setOnClickListener(this);
        this.goT.setOnClickListener(this);
        this.goV.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eNi != null) {
            this.eNi.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eNi != null) {
            this.eNi.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eNi != null) {
            this.eNi.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.goK != null) {
            this.mSkinType = i;
            this.goL.setIsNight(this.mSkinType == 1);
            if (this.goK.gnU) {
                if (this.goK.gnT == 1) {
                    am.setImageResource(this.goM, R.drawable.label_topic_agree_red);
                    this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.goK.gnT == 2) {
                    am.setImageResource(this.goM, R.drawable.label_topic_disagree_blue);
                    this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.setImageResource(this.goM, R.drawable.label_topic_eat_black);
                    this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.setViewTextColor(this.csn, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.goN, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.goP, (int) R.drawable.selector_topic_detail_comment_text_color);
            if (this.goQ != null) {
                SvgManager.amN().a(this.goQ, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.goO.onChangeSkinType(i);
            this.goR.setTextColor(am.getColor(R.color.cp_cont_b));
            am.e(this.goT, l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds6), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
            am.setViewTextColor(this.goV, (int) R.color.cp_cont_d);
            this.eNi.onChangeSkinType();
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
        int aix;
        AgreeData akv;
        if (cVar != null && cVar.cbq != null) {
            this.goK = cVar;
            onChangeSkinType(this.cfl, TbadkCoreApplication.getInst().getSkinType());
            bh bhVar = this.goK.cbq;
            PostData akd = bhVar.akd();
            if (akd != null) {
                if (this.goK.source == 1) {
                    this.goL.setData(bhVar, false, true);
                } else {
                    this.goL.setData(bhVar, false, false);
                }
                this.goL.setDefaultResource(R.drawable.icon_default_avatar100);
                this.goL.setDefaultBgResource(R.color.cp_bg_line_e);
                this.goL.setIsRound(true);
                this.goL.setBorderWidth(2);
                this.goL.setDrawBorder(true);
                this.goL.setPageId(this.cfl.getUniqueId());
                if (this.goK.gnU) {
                    this.goM.setVisibility(0);
                    if (this.goK.gnT == 1) {
                        this.goM.setImageResource(R.drawable.label_topic_agree_red);
                        this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.goK.gnT == 2) {
                        this.goM.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.goM.setImageResource(R.drawable.label_topic_eat_black);
                        this.goL.setBorderColor(this.cfl.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.goM.setVisibility(8);
                }
                if (this.goK.source == 1) {
                    name_show = akd.aiG().getName_show();
                    formatTime = aq.getFormatTime(akd.getTime());
                    aix = akd.cot();
                } else {
                    name_show = bhVar.aiG().getName_show();
                    formatTime = aq.getFormatTime(bhVar.getCreateTime());
                    aix = bhVar.aix();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.csn.setText(aq.cutChineseAndEnglishWithSuffix(name_show, 14, StringHelper.STRING_MORE));
                }
                if (StringUtils.isNull(bhVar.aiL())) {
                    this.goN.setText(formatTime);
                } else {
                    this.goN.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.cutChineseAndEnglishWithSuffix(bhVar.aiL(), 10, StringHelper.STRING_MORE), formatTime));
                }
                SvgManager.amN().a(this.goQ, R.drawable.icon_pure_pb_bottom_comment_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                String numFormatOverWan = aq.numFormatOverWan(aix);
                if (aix > 0) {
                    this.goP.setVisibility(0);
                    this.goP.setText(numFormatOverWan);
                } else {
                    this.goP.setText(this.cfl.getString(R.string.action_comment_default));
                    this.goP.setVisibility(0);
                }
                if (this.goK.source == 1) {
                    akv = akd.akv();
                    akv.objType = 1;
                } else {
                    akv = bhVar.akv();
                    akv.objType = 3;
                }
                akv.threadId = bhVar.getTid();
                this.goO.setData(akv);
                this.goO.setTopicId(String.valueOf(this.goK.topicId));
                if (this.goK.source == 1) {
                    this.goR.setVisibility(0);
                    this.goR.setText(akd.cor());
                } else {
                    this.goR.setVisibility(0);
                    int size = bhVar.aiw().size();
                    if (StringUtils.isNull(bhVar.akg().toString()) && size <= 0) {
                        this.goR.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bhVar.aiw(), false);
                        if (a != null) {
                            this.goR.setText(a);
                        }
                    } else if (!StringUtils.isNull(bhVar.akg().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bhVar.akg().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.goR.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.goR.setVisibility(8);
                    }
                }
                if (this.goK.source == 1) {
                    this.goT.setVisibility(0);
                    this.goS.setVisibility(8);
                    ArrayList<MediaData> aiQ = bhVar.aiQ();
                    String str = null;
                    String title = bhVar.getTitle();
                    if (v.getCount(aiQ) != 0 && !v.isEmpty(cVar.cbq.aiQ())) {
                        Iterator<MediaData> it = cVar.cbq.aiQ().iterator();
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
                        this.goT.setVisibility(8);
                    } else {
                        this.goT.setVisibility(0);
                        this.goV.setText(title);
                        if (StringUtils.isNull(str)) {
                            am.setImageResource(this.goU, R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.goU.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.goT.setVisibility(8);
                    this.goS.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bh bhVar = cVar.cbq;
        ArrayList<MediaData> aiQ = bhVar.aiQ();
        if (i.agq().isShowImages() && v.getCount(aiQ) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aiQ.size(); i++) {
                MediaData mediaData = (MediaData) v.getItem(aiQ, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.getCount(linkedList) > 0) {
                this.goS.setVisibility(0);
                this.eNi.setFromCDN(this.HY);
                this.eNi.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void b(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bhVar);
                        } else {
                            d.this.asj();
                        }
                    }
                });
                this.eNi.setImageMediaList(linkedList);
                return;
            }
            this.goS.setVisibility(8);
            return;
        }
        this.goS.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eNi != null) {
            this.eNi.setPageUniqueId(bdUniqueId);
        }
    }

    public void asj() {
        if (this.goK != null && this.goK.cbq != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.cfl.getPageActivity()).createFromThreadCfg(this.goK.cbq, null, IXAdSystemUtils.NT_NONE, RequestResponseCode.REQUEST_FRS_TO_PB, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.goK.cbq.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.goK.cbq.aiL());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.uz(this.goK.cbq.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void bvC() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.cfl.getPageActivity()).createNormalCfg(String.valueOf(this.goK.cbq.getTid()), String.format("%1$s", this.goK.cbq.akd().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.urlType = this.HY ? 13 : 14;
                    imageUrlData.imageUrl = mediaData.getPicUrl();
                    imageUrlData.originalUrl = mediaData.getOriginalUrl();
                    imageUrlData.originalSize = mediaData.getOriginalSize();
                    imageUrlData.isLongPic = mediaData.isLongPic();
                    imageUrlData.mIsShowOrigonButton = mediaData.isShowOriginBtn();
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.toLong(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aiL(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.HY, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
        if (this.currentPageType == 2) {
            createConfig.getIntent().putExtra("from", "index");
        } else {
            createConfig.getIntent().putExtra("from", "other");
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        createConfig.setSrcRectInScreen(rect, UtilHelper.fixedDrawableRect(rect, view));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.mTbPageContext;
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aiL();
        historyMessage.postID = bhVar.aiW();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.goK != null && this.goK.cbq != null) {
            if (view == this.goR) {
                if (this.goK.source == 1) {
                    bvC();
                } else {
                    asj();
                }
                xc("1");
            }
            if (view == this.goP || view == this.goQ) {
                if (this.goK.source == 1) {
                    bvC();
                } else {
                    asj();
                }
                xc("3");
            } else if (view == this.csn) {
                bvD();
            } else {
                asj();
                xc("2");
            }
        }
    }

    private void bvD() {
        MetaData aiG;
        if (this.goK != null && this.goK.cbq != null) {
            bh bhVar = this.goK.cbq;
            if (this.goK.source == 1 && bhVar.akd() != null) {
                aiG = bhVar.akd().aiG();
            } else {
                aiG = bhVar.aiG();
            }
            if (aiG != null && !StringUtils.isNull(aiG.getName_show()) && !StringUtils.isNull(aiG.getUserId())) {
                long j = com.baidu.adp.lib.g.b.toLong(aiG.getUserId(), 0L);
                boolean z = j == com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (bhVar.ajP() != null && bhVar.ajP().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(getContext(), bhVar.ajP().channelId, bhVar.ajP().ZN)));
                    return;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(j, z, aiG.isBigV());
                createNormalConfig.setSourceTid(bhVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createNormalConfig));
            }
        }
    }

    private void xc(String str) {
        TiebaStatic.log(new an("c13356").bS("obj_locate", str).bS("tid", this.goK.cbq.getTid()).p("topic_id", this.goK.topicId).bS("obj_type", String.valueOf(this.goK.source)));
    }
}

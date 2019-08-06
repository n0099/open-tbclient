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
    private int cbP;
    private TextView cdg;
    private ConstrainImageGroup eCT;
    private ImageView gnA;
    private TbRichTextView gnB;
    private RelativeLayout gnC;
    private View gnD;
    private TbImageView gnE;
    private TextView gnF;
    private com.baidu.tieba.homepage.topic.topicdetail.b.c gnu;
    private ClickableHeaderImageView gnv;
    private ImageView gnw;
    private TextView gnx;
    private AgreeAloneView gny;
    private TextView gnz;
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
        this.cbP = R.drawable.selector_topic_detail_comment_icon;
        this.gnv = (ClickableHeaderImageView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_header);
        this.gnw = (ImageView) view.findViewById(R.id.card_topic_detail_thread_opinion_img);
        this.cdg = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_user_name);
        this.gnx = (TextView) view.findViewById(R.id.card_topic_detail_discuss_thread_forum_name);
        this.gnB = (TbRichTextView) view.findViewById(R.id.card_topic_detail_discuss_title);
        this.gnB.setClickable(true);
        this.gnB.getLayoutStrategy().setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds20), 1.0f);
        this.gnB.setTextEllipsize(TextUtils.TruncateAt.END);
        this.gnB.setMaxLines(2);
        com.baidu.tbadk.widget.richText.a aVar = new com.baidu.tbadk.widget.richText.a();
        aVar.setTextSize(l.g(getContext(), R.dimen.tbds44));
        aVar.setLineSpacing(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds7), 1.0f);
        this.gnB.setLayoutStrategy(aVar);
        this.gnC = (RelativeLayout) view.findViewById(R.id.topic_detail_img_container);
        this.eCT = (ConstrainImageGroup) view.findViewById(R.id.card_topic_detail_discuss_thread_img_layout);
        this.eCT.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        com.baidu.tbadk.widget.layout.a aVar2 = new com.baidu.tbadk.widget.layout.a(3);
        aVar2.h(1.0d);
        this.eCT.setImageProcessor(aVar2);
        this.gny = (AgreeAloneView) view.findViewById(R.id.card_topic_detail_discuss_argee_view);
        this.gnz = (TextView) view.findViewById(R.id.topic_comment_number);
        this.gnA = (ImageView) view.findViewById(R.id.topic_comment_pic);
        this.gnD = view.findViewById(R.id.card_topic_detail_discuss_original_thread_layout);
        this.gnE = (TbImageView) view.findViewById(R.id.card_topic_discuss_original_thread_pic);
        this.gnE.setRadius(l.g(getContext(), R.dimen.tbds6));
        this.gnE.setConrers(5);
        this.gnE.setDrawCorner(true);
        this.gnF = (TextView) view.findViewById(R.id.card_topic_discuss_original_thread_title);
        this.mBottomLine = view.findViewById(R.id.card_topic_detail_discuss_line_layout);
        this.cdg.setOnClickListener(this);
        this.gnz.setOnClickListener(this);
        this.gnA.setOnClickListener(this);
        this.gnB.setOnClickListener(this);
        this.gnD.setOnClickListener(this);
        this.gnF.setOnClickListener(this);
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<ConstrainImageLayout> bVar) {
        if (this.eCT != null) {
            this.eCT.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        if (this.eCT != null) {
            this.eCT.setImageViewPool(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void setPreloadSizeReadyCallback(com.baidu.adp.widget.a.b bVar) {
        if (this.eCT != null) {
            this.eCT.setPreloadSizeReadyCallback(bVar);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i && this.gnu != null) {
            this.mSkinType = i;
            this.gnv.setIsNight(this.mSkinType == 1);
            if (this.gnu.gmE) {
                if (this.gnu.gmD == 1) {
                    am.c(this.gnw, (int) R.drawable.label_topic_agree_red);
                    this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                } else if (this.gnu.gmD == 2) {
                    am.c(this.gnw, (int) R.drawable.label_topic_disagree_blue);
                    this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                } else {
                    am.c(this.gnw, (int) R.drawable.label_topic_eat_black);
                    this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                }
            }
            am.j(this.cdg, R.color.cp_cont_b);
            am.j(this.gnx, R.color.cp_cont_d);
            am.j(this.gnz, R.drawable.selector_topic_detail_comment_text_color);
            if (this.gnA != null && this.cbP > 0) {
                this.gnA.setImageDrawable(am.getDrawable(this.cbP));
            }
            this.gny.onChangeSkinType(i);
            this.gnB.setTextColor(am.getColor(R.color.cp_cont_b));
            am.k(this.gnD, R.drawable.topic_original_bg_corner);
            am.j(this.gnF, R.color.cp_cont_d);
            this.eCT.onChangeSkinType();
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
        int aep;
        AgreeData ago;
        if (cVar != null && cVar.threadData != null) {
            this.gnu = cVar;
            onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            bh bhVar = this.gnu.threadData;
            PostData afW = bhVar.afW();
            if (afW != null) {
                if (this.gnu.source == 1) {
                    this.gnv.setData(bhVar, false, true);
                } else {
                    this.gnv.setData(bhVar, false, false);
                }
                this.gnv.setDefaultResource(R.drawable.icon_default_avatar100);
                this.gnv.setDefaultBgResource(R.color.cp_bg_line_e);
                this.gnv.setIsRound(true);
                this.gnv.setBorderWidth(2);
                this.gnv.setDrawBorder(true);
                this.gnv.setPageId(this.mContext.getUniqueId());
                if (this.gnu.gmE) {
                    this.gnw.setVisibility(0);
                    if (this.gnu.gmD == 1) {
                        this.gnw.setImageResource(R.drawable.label_topic_agree_red);
                        this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_h));
                    } else if (this.gnu.gmD == 2) {
                        this.gnw.setImageResource(R.drawable.label_topic_disagree_blue);
                        this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_link_tip_a));
                    } else {
                        this.gnw.setImageResource(R.drawable.label_topic_eat_black);
                        this.gnv.setBorderColor(this.mContext.getPageActivity().getResources().getColor(R.color.cp_cont_f));
                    }
                } else {
                    this.gnw.setVisibility(8);
                }
                if (this.gnu.source == 1) {
                    name_show = afW.aey().getName_show();
                    aD = aq.aD(afW.getTime());
                    aep = afW.cpP();
                } else {
                    name_show = bhVar.aey().getName_show();
                    aD = aq.aD(bhVar.getCreateTime());
                    aep = bhVar.aep();
                }
                if (!StringUtils.isNull(name_show)) {
                    this.cdg.setText(aq.j(name_show, 14, "..."));
                }
                if (StringUtils.isNull(bhVar.aeD())) {
                    this.gnx.setText(aD);
                } else {
                    this.gnx.setText(String.format(getContext().getString(R.string.daily_topic_discuss_forum_name), aq.j(bhVar.aeD(), 10, "..."), aD));
                }
                this.gnA.setImageDrawable(am.getDrawable(this.cbP));
                String aO = aq.aO(aep);
                if (aep > 0) {
                    this.gnz.setVisibility(0);
                    this.gnz.setText(aO);
                } else {
                    this.gnz.setText(this.mContext.getString(R.string.action_comment_default));
                    this.gnz.setVisibility(0);
                }
                if (this.gnu.source == 1) {
                    ago = afW.ago();
                    ago.objType = 1;
                } else {
                    ago = bhVar.ago();
                    ago.objType = 3;
                }
                ago.threadId = bhVar.getTid();
                this.gny.setData(ago);
                this.gny.setTopicId(String.valueOf(this.gnu.topicId));
                if (this.gnu.source == 1) {
                    this.gnB.setVisibility(0);
                    this.gnB.setText(afW.cpN());
                } else {
                    this.gnB.setVisibility(0);
                    int size = bhVar.aeo().size();
                    if (StringUtils.isNull(bhVar.afZ().toString()) && size <= 0) {
                        this.gnB.setVisibility(8);
                    } else if (size > 0) {
                        TbRichText a = TbRichTextView.a(getContext(), bhVar.aeo(), false);
                        if (a != null) {
                            this.gnB.setText(a);
                        }
                    } else if (!StringUtils.isNull(bhVar.afZ().toString())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "0");
                            jSONObject.put("text", bhVar.afZ().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObject);
                        this.gnB.setText(TbRichTextView.a(getContext(), jSONArray, false));
                    } else {
                        this.gnB.setVisibility(8);
                    }
                }
                if (this.gnu.source == 1) {
                    this.gnD.setVisibility(0);
                    this.gnC.setVisibility(8);
                    ArrayList<MediaData> aeI = bhVar.aeI();
                    String str = null;
                    String title = bhVar.getTitle();
                    if (v.Z(aeI) != 0 && !v.aa(cVar.threadData.aeI())) {
                        Iterator<MediaData> it = cVar.threadData.aeI().iterator();
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
                        this.gnD.setVisibility(8);
                    } else {
                        this.gnD.setVisibility(0);
                        this.gnF.setText(title);
                        if (StringUtils.isNull(str)) {
                            am.c(this.gnE, (int) R.drawable.pic_frs_topic_shareinone);
                        } else {
                            this.gnE.startLoad(str, 10, false);
                        }
                    }
                } else {
                    this.gnD.setVisibility(8);
                    this.gnC.setVisibility(0);
                    b(cVar);
                }
                setPageUniqueId(getTag());
            }
        }
    }

    private void b(com.baidu.tieba.homepage.topic.topicdetail.b.c cVar) {
        final bh bhVar = cVar.threadData;
        ArrayList<MediaData> aeI = bhVar.aeI();
        if (i.aca().ace() && v.Z(aeI) != 0) {
            final LinkedList linkedList = new LinkedList();
            for (int i = 0; i < aeI.size(); i++) {
                MediaData mediaData = (MediaData) v.c(aeI, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    linkedList.add(mediaData);
                }
            }
            if (v.Z(linkedList) > 0) {
                this.gnC.setVisibility(0);
                this.eCT.setFromCDN(this.Yd);
                this.eCT.setImageClickListener(new com.baidu.tbadk.widget.layout.d() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.d.1
                    @Override // com.baidu.tbadk.widget.layout.d
                    public void a(View view, int i2, boolean z) {
                        if (!z) {
                            d.this.a(view, linkedList, i2, bhVar);
                        } else {
                            d.this.aqd();
                        }
                    }
                });
                this.eCT.setImageMediaList(linkedList);
                return;
            }
            this.gnC.setVisibility(8);
            return;
        }
        this.gnC.setVisibility(8);
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        setTag(bdUniqueId);
        if (this.eCT != null) {
            this.eCT.setPageUniqueId(bdUniqueId);
        }
    }

    public void aqd() {
        if (this.gnu != null && this.gnu.threadData != null) {
            PbActivityConfig addLocateParam = new PbActivityConfig(this.mContext.getPageActivity()).createFromThreadCfg(this.gnu.threadData, null, IXAdSystemUtils.NT_NONE, 18003, true, false, false).addLocateParam(null);
            addLocateParam.setForumId(String.valueOf(this.gnu.threadData.getFid()));
            addLocateParam.setFrom(PbActivityConfig.KEY_FROM_PERSONALIZE);
            addLocateParam.setForumName(this.gnu.threadData.aeD());
            addLocateParam.setStartFrom(this.currentPageType);
            addLocateParam.setJumpGodReply(false);
            n.vx(this.gnu.threadData.getTid());
            this.mTbPageContext.sendMessage(new CustomMessage(2004001, addLocateParam));
        }
    }

    private void bxK() {
        PbActivityConfig createNormalCfg = new PbActivityConfig(this.mContext.getPageActivity()).createNormalCfg(String.valueOf(this.gnu.threadData.getTid()), String.format("%1$s", this.gnu.threadData.afW().getId()) + "", 1, "mention");
        createNormalCfg.setStartFrom(12);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, List<MediaData> list, int i, bh bhVar) {
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
                    imageUrlData.threadId = com.baidu.adp.lib.g.b.c(bhVar.getTid(), -1L);
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
        ImageViewerConfig createConfig = new ImageViewerConfig(this.mTbPageContext.getPageActivity()).createConfig(arrayList, i, bhVar.aeD(), String.valueOf(bhVar.getFid()), bhVar.getTid(), this.Yd, arrayList.size() > 0 ? arrayList.get(0) : "", true, concurrentHashMap, true);
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
        historyMessage.threadId = bhVar.getId();
        historyMessage.threadName = bhVar.getTitle();
        historyMessage.forumName = bhVar.aeD();
        historyMessage.postID = bhVar.aeO();
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnu != null && this.gnu.threadData != null) {
            if (view == this.gnB) {
                if (this.gnu.source == 1) {
                    bxK();
                } else {
                    aqd();
                }
                yk("1");
            }
            if (view == this.gnz || view == this.gnA) {
                if (this.gnu.source == 1) {
                    bxK();
                } else {
                    aqd();
                }
                yk("3");
            } else if (view == this.cdg) {
                bxL();
            } else {
                aqd();
                yk("2");
            }
        }
    }

    private void bxL() {
        MetaData aey;
        if (this.gnu != null && this.gnu.threadData != null) {
            bh bhVar = this.gnu.threadData;
            if (this.gnu.source == 1 && bhVar.afW() != null) {
                aey = bhVar.afW().aey();
            } else {
                aey = bhVar.aey();
            }
            if (aey != null && !StringUtils.isNull(aey.getName_show()) && !StringUtils.isNull(aey.getUserId())) {
                long c = com.baidu.adp.lib.g.b.c(aey.getUserId(), 0L);
                boolean z = c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                if (bhVar.afI() != null && bhVar.afI().channelId > 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChannelHomeActivityConfig(getContext(), bhVar.afI().channelId, bhVar.afI().mCurrentPage)));
                    return;
                }
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(getContext()).createNormalConfig(c, z, aey.isBigV());
                createNormalConfig.setSourceTid(bhVar.getTid());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            }
        }
    }

    private void yk(String str) {
        TiebaStatic.log(new an("c13356").bT("obj_locate", str).bT("tid", this.gnu.threadData.getTid()).l("topic_id", this.gnu.topicId).bT("obj_type", String.valueOf(this.gnu.source)));
    }
}

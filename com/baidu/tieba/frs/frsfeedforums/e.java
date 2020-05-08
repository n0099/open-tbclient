package com.baidu.tieba.frs.frsfeedforums;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter {
    private LikeModel dKs;
    private TbPageContext<FrsMoreFeedForumsActivity> duK;
    private List<FeedForumData> hke;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.duK.getOrignalPage()).checkUpIsLogin()) {
                        e.this.dKs.eP(feedForumData.getForumName(), feedForumData.getForumId());
                        an anVar = new an("c10048");
                        anVar.cI("fid", feedForumData.getForumId());
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(anVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.duK.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.duK.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new an("c10050").cI("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d gBi = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bq(e.this.dKs.getErrorCode(), e.this.dKs.getErrorString())) {
                AntiHelper.aW(e.this.duK.getPageActivity(), e.this.dKs.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.dKs.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.dKs.getErrorString());
                }
            } else {
                u uVar = (u) obj;
                uVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.duK = tbPageContext;
        this.dKs = new LikeModel(tbPageContext);
        this.dKs.setLoadDataCallBack(this.gBi);
    }

    public void setData(List<FeedForumData> list) {
        this.hke = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hke != null) {
            return this.hke.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hke != null) {
            return this.hke.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.hkm.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.eAX.setOnClickListener(this.mOnClickListener);
        bVar.hkj.setPlaceHolder(1);
        bVar.hkj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.hkj.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.hkk.setText(String.format(this.duK.getPageActivity().getString(R.string.attention_post_count), tT(feedForumData.getMemberCount()), tT(feedForumData.getPostNum())));
        bVar.hkl.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.hkm.setClickable(true);
            bVar.hkm.setOnClickListener(this.mOnClickListener);
            bVar.hkm.setEnabled(true);
            bVar.hkm.gT(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.afW != this.mSkinType) {
            am.setBackgroundResource(bVar.eAX, R.drawable.frs_like_feed_forum_item_bg);
            am.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            am.setViewTextColor(bVar.hkk, R.color.cp_cont_c, 1);
            am.setViewTextColor(bVar.hkl, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                am.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.afW = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.hkm != null) {
            bVar.hkm.gT(true);
            bVar.hkm.setEnabled(false);
        }
    }

    private String tT(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        if (i / 10000.0f <= 9999.9f) {
            return String.format("%.1fW", Float.valueOf(i / 10000.0f));
        }
        return "9999.9+W";
    }

    public void a(List<FeedForumData> list, u uVar) {
        if (list != null && list.size() > 0 && uVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(uVar.getFid())) {
                    feedForumData.setIsLike(uVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}

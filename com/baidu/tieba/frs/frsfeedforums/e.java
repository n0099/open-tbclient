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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import java.util.List;
/* loaded from: classes16.dex */
public class e extends BaseAdapter {
    private TbPageContext<FrsMoreFeedForumsActivity> efn;
    private LikeModel ewX;
    private List<FeedForumData> igW;
    private int mSkinType;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.frsfeedforums.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            b bVar = (b) view.getTag();
            if (bVar != null && (feedForumData = (FeedForumData) e.this.getItem(bVar.position)) != null) {
                if (view.getId() == R.id.frs_feed_forum_attention) {
                    if (((FrsMoreFeedForumsActivity) e.this.efn.getOrignalPage()).checkUpIsLogin()) {
                        e.this.ewX.fQ(feedForumData.getForumName(), feedForumData.getForumId());
                        aq aqVar = new aq("c10048");
                        aqVar.dD("fid", feedForumData.getForumId());
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        }
                        TiebaStatic.log(aqVar);
                    }
                } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                    e.this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(e.this.efn.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                    TiebaStatic.log(new aq("c10050").dD("fid", feedForumData.getForumId()));
                }
            }
        }
    };
    private com.baidu.adp.base.d hvu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.frsfeedforums.e.2
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (AntiHelper.bz(e.this.ewX.getErrorCode(), e.this.ewX.getErrorString())) {
                AntiHelper.bb(e.this.efn.getPageActivity(), e.this.ewX.getErrorString());
            } else if (obj == null) {
                if (!StringUtils.isNull(e.this.ewX.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), e.this.ewX.getErrorString());
                }
            } else {
                v vVar = (v) obj;
                vVar.setLike(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
            }
        }
    };

    public e(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.efn = tbPageContext;
        this.ewX = new LikeModel(tbPageContext);
        this.ewX.setLoadDataCallBack(this.hvu);
    }

    public void setData(List<FeedForumData> list) {
        this.igW = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.igW != null) {
            return this.igW.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.igW != null) {
            return this.igW.get(i);
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
            view = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar2.ihe.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.position = i;
        bVar.fpN.setOnClickListener(this.mOnClickListener);
        bVar.ihb.setPlaceHolder(1);
        bVar.ihb.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.ihb.startLoad(feedForumData.getAvatar(), 15, false);
        bVar.mTitle.setText(feedForumData.getForumName());
        bVar.ihc.setText(String.format(this.efn.getPageActivity().getString(R.string.attention_post_count), xQ(feedForumData.getMemberCount()), xQ(feedForumData.getPostNum())));
        bVar.ihd.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.ihe.setClickable(true);
            bVar.ihe.setOnClickListener(this.mOnClickListener);
            bVar.ihe.setEnabled(true);
            bVar.ihe.aN(false);
        } else {
            a(bVar);
        }
        b(bVar);
        return view;
    }

    private void b(b bVar) {
        if (bVar.aiB != this.mSkinType) {
            ap.setBackgroundResource(bVar.fpN, R.drawable.frs_like_feed_forum_item_bg);
            ap.setViewTextColor(bVar.mTitle, R.color.cp_cont_b, 1);
            ap.setViewTextColor(bVar.ihc, R.color.cp_cont_c, 1);
            ap.setViewTextColor(bVar.ihd, R.color.cp_link_tip_d, 1);
            if (bVar.mDivider != null) {
                ap.setBackgroundColor(bVar.mDivider, R.color.cp_bg_line_c);
            }
            bVar.aiB = this.mSkinType;
        }
    }

    private void a(b bVar) {
        if (bVar != null && bVar.ihe != null) {
            bVar.ihe.aN(true);
            bVar.ihe.setEnabled(false);
        }
    }

    private String xQ(int i) {
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

    public void a(List<FeedForumData> list, v vVar) {
        if (list != null && list.size() > 0 && vVar != null) {
            for (FeedForumData feedForumData : list) {
                if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(vVar.getFid())) {
                    feedForumData.setIsLike(vVar.isLike());
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}

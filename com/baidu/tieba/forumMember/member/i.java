package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivityConfig;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes7.dex */
public class i extends com.baidu.tieba.frs.k<j, FrsMemberTeamViewHolder> {
    private View.OnClickListener mClickListener;

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.i.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (view.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view.getTag();
                    i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(i.this.mContext, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view.getId() == R.id.title_text_view) {
                    Object tag = view.getTag();
                    j jVar = ((tag instanceof Integer) && (i.this.getItem(((Integer) tag).intValue()) instanceof j)) ? (j) i.this.getItem(((Integer) tag).intValue()) : null;
                    if (jVar != null && jVar.czC() != null) {
                        String[] split = !StringUtils.isNull(jVar.czC().member_group_type) ? jVar.czC().member_group_type.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) : null;
                        if (split == null || split.length != 2) {
                            str = "";
                        } else {
                            str = split[0];
                        }
                        if (!StringUtils.isNull(str) && str.equalsIgnoreCase("1")) {
                            i.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BawuTeamInfoActivityConfig(i.this.mContext, com.baidu.adp.lib.f.b.toLong(jVar.getForumId(), 0L))));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bp */
    public FrsMemberTeamViewHolder e(ViewGroup viewGroup) {
        return new FrsMemberTeamViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_team_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, FrsMemberTeamViewHolder frsMemberTeamViewHolder) {
        super.a(i, view, viewGroup, (ViewGroup) jVar, (j) frsMemberTeamViewHolder);
        if (jVar != null && jVar.czC() != null) {
            MemberGroupInfo czC = jVar.czC();
            if (czC.member_group_list != null && czC.member_group_list.size() > 0 && !StringUtils.isNull(czC.member_group_type)) {
                frsMemberTeamViewHolder.mTitleView.setTag(Integer.valueOf(i));
                String str = "";
                String[] split = !StringUtils.isNull(czC.member_group_type) ? czC.member_group_type.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) : null;
                if (split != null && split.length == 2) {
                    str = split[1];
                }
                frsMemberTeamViewHolder.mTitleView.setText(str + "(" + czC.member_group_num + ")");
                int i2 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : czC.member_group_list) {
                    if (i2 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        frsMemberTeamViewHolder.a(bawuRoleInfoPub, i2);
                        i2++;
                    }
                }
                frsMemberTeamViewHolder.qd(this.mSkinType == 1);
                ao.setBackgroundColor(frsMemberTeamViewHolder.iXn, R.color.CAM_X0201);
                ao.setViewTextColor(frsMemberTeamViewHolder.mTitleView, R.color.CAM_X0105, 1);
                ao.setViewTextColor(frsMemberTeamViewHolder.iXj, R.color.CAM_X0106, 1);
                ao.setViewTextColor(frsMemberTeamViewHolder.iXk, R.color.CAM_X0106, 1);
                ao.setViewTextColor(frsMemberTeamViewHolder.iXl, R.color.CAM_X0106, 1);
                ao.setViewTextColor(frsMemberTeamViewHolder.iXm, R.color.CAM_X0106, 1);
                frsMemberTeamViewHolder.mTitleView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            }
        }
        return view;
    }
}

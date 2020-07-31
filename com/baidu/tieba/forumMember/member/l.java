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
/* loaded from: classes17.dex */
public class l extends com.baidu.tieba.frs.j<m, n> {
    private View.OnClickListener mClickListener;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (view.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view.getTag();
                    l.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(l.this.mContext, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view.getId() == R.id.title_text_view) {
                    Object tag = view.getTag();
                    m mVar = ((tag instanceof Integer) && (l.this.getItem(((Integer) tag).intValue()) instanceof m)) ? (m) l.this.getItem(((Integer) tag).intValue()) : null;
                    if (mVar != null && mVar.bZR() != null) {
                        String[] split = !StringUtils.isNull(mVar.bZR().member_group_type) ? mVar.bZR().member_group_type.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) : null;
                        if (split == null || split.length != 2) {
                            str = "";
                        } else {
                            str = split[0];
                        }
                        if (!StringUtils.isNull(str) && str.equalsIgnoreCase("1")) {
                            l.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BawuTeamInfoActivityConfig(l.this.mContext, com.baidu.adp.lib.f.b.toLong(mVar.getForumId(), 0L))));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public n b(ViewGroup viewGroup) {
        return new n(LayoutInflater.from(this.mContext).inflate(R.layout.forum_member_team_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, n nVar) {
        super.a(i, view, viewGroup, (ViewGroup) mVar, (m) nVar);
        if (mVar != null && mVar.bZR() != null) {
            MemberGroupInfo bZR = mVar.bZR();
            if (bZR.member_group_list != null && bZR.member_group_list.size() > 0 && !StringUtils.isNull(bZR.member_group_type)) {
                nVar.mTitleView.setTag(Integer.valueOf(i));
                String str = "";
                String[] split = !StringUtils.isNull(bZR.member_group_type) ? bZR.member_group_type.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) : null;
                if (split != null && split.length == 2) {
                    str = split[1];
                }
                nVar.mTitleView.setText(str + "(" + bZR.member_group_num + ")");
                int i2 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : bZR.member_group_list) {
                    if (i2 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        nVar.a(bawuRoleInfoPub, i2);
                        i2++;
                    }
                }
                nVar.ns(this.mSkinType == 1);
                ao.setBackgroundColor(nVar.hCl, R.color.cp_bg_line_d);
                ao.setViewTextColor(nVar.mTitleView, R.color.cp_cont_b, 1);
                ao.setViewTextColor(nVar.hCh, R.color.cp_cont_f, 1);
                ao.setViewTextColor(nVar.hCi, R.color.cp_cont_f, 1);
                ao.setViewTextColor(nVar.hCj, R.color.cp_cont_f, 1);
                ao.setViewTextColor(nVar.hCk, R.color.cp_cont_f, 1);
                nVar.mTitleView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            }
        }
        return view;
    }
}

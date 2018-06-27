package com.baidu.tieba.forumMember.member;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.forumMember.bawu.BawuTeamInfoActivityConfig;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes3.dex */
public class l extends com.baidu.tieba.frs.h<m, n> {
    private View.OnClickListener mClickListener;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.forumMember.member.l.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (view.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view.getTag();
                    l.this.mPageContext.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(l.this.mContext, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view.getId() == d.g.title_text_view) {
                    Object tag = view.getTag();
                    m mVar = ((tag instanceof Integer) && (l.this.getItem(((Integer) tag).intValue()) instanceof m)) ? (m) l.this.getItem(((Integer) tag).intValue()) : null;
                    if (mVar != null && mVar.asz() != null) {
                        String[] split = !StringUtils.isNull(mVar.asz().member_group_type) ? mVar.asz().member_group_type.split("_") : null;
                        if (split == null || split.length != 2) {
                            str = "";
                        } else {
                            str = split[0];
                        }
                        if (!StringUtils.isNull(str) && str.equalsIgnoreCase("1")) {
                            l.this.mPageContext.sendMessage(new CustomMessage(2002001, new BawuTeamInfoActivityConfig(l.this.mContext, com.baidu.adp.lib.g.b.c(mVar.getForumId(), 0L))));
                        }
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aj */
    public n onCreateViewHolder(ViewGroup viewGroup) {
        return new n(LayoutInflater.from(this.mContext).inflate(d.i.forum_member_team_user_view, (ViewGroup) null), this.mClickListener);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, m mVar, n nVar) {
        super.onFillViewHolder(i, view, viewGroup, mVar, nVar);
        if (mVar != null && mVar.asz() != null) {
            MemberGroupInfo asz = mVar.asz();
            if (asz.member_group_list != null && asz.member_group_list.size() > 0 && !StringUtils.isNull(asz.member_group_type)) {
                nVar.mTitleView.setTag(Integer.valueOf(i));
                String str = "";
                String[] split = !StringUtils.isNull(asz.member_group_type) ? asz.member_group_type.split("_") : null;
                if (split != null && split.length == 2) {
                    str = split[1];
                }
                nVar.mTitleView.setText(str + "(" + asz.member_group_num + ")");
                int i2 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : asz.member_group_list) {
                    if (i2 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        nVar.a(bawuRoleInfoPub, i2);
                        i2++;
                    }
                }
                nVar.fq(this.mSkinType == 1);
                am.j(nVar.dgQ, d.C0142d.cp_bg_line_d);
                am.j(nVar.dgR, d.C0142d.cp_bg_line_b);
                am.c(nVar.mTitleView, d.C0142d.cp_cont_c, 1);
                am.c(nVar.dgM, d.C0142d.cp_cont_f, 1);
                am.c(nVar.dgN, d.C0142d.cp_cont_f, 1);
                am.c(nVar.dgO, d.C0142d.cp_cont_f, 1);
                am.c(nVar.dgP, d.C0142d.cp_cont_f, 1);
                nVar.mTitleView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(d.f.icon_arrow_tab), (Drawable) null);
            }
        }
        return view;
    }
}

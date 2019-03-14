package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class b extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private TextView btZ;
    private TextView cny;
    private TextView eqt;
    private TextView equ;
    private TextView eqy;
    private LinearLayout eqz;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.btZ = (TextView) view.findViewById(d.g.chosen_no_picture_title);
        this.eqt = (TextView) view.findViewById(d.g.chosen_no_picture_praise);
        this.equ = (TextView) view.findViewById(d.g.chosen_no_picture_comment);
        this.eqy = (TextView) view.findViewById(d.g.chosen_no_picture_head);
        this.cny = (TextView) view.findViewById(d.g.chosen_no_picture_sub);
        this.eqz = (LinearLayout) view.findViewById(d.g.chosen_no_picture_comment_line);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(final tinfo tinfoVar) {
        super.af(tinfoVar);
        if (StringUtils.isNull(tinfoVar.title)) {
            this.eqy.setVisibility(8);
        } else {
            this.eqy.setVisibility(0);
            this.eqy.setText(tinfoVar.title);
        }
        if (StringUtils.isNull(tinfoVar.forum_name)) {
            this.eqz.setVisibility(8);
        } else {
            this.eqz.setVisibility(0);
            this.btZ.setVisibility(0);
            this.btZ.setText(UtilHelper.getFixedText(getContext().getString(d.j.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
            this.btZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = tinfoVar.forum_name;
                    if (ap.bv(str)) {
                        TiebaStatic.eventStat(b.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(b.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                    }
                }
            });
            if (tinfoVar.zan_num == null) {
                this.eqt.setVisibility(8);
            } else {
                this.eqt.setVisibility(0);
                this.eqt.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.equ.setVisibility(8);
            } else {
                this.equ.setVisibility(0);
                this.equ.setText(tinfoVar.reply_num + "");
            }
        }
        if (StringUtils.isNull(tinfoVar._abstract)) {
            this.cny.setVisibility(8);
            return;
        }
        this.cny.setVisibility(0);
        this.cny.setText(tinfoVar._abstract);
    }
}

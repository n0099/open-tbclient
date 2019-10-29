package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes5.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aju;
    private TextView bUW;
    private TextView eVh;
    private TextView eVi;
    private TextView eVm;
    private RelativeLayout eVq;
    private TbImageView eVr;
    private TbImageView eVs;
    private TbImageView eVt;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.awx().dispatchMvcEvent(bVar);
                }
            }
        };
        this.bUW = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.eVh = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.eVi = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.eVm = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.eVq = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.eVr = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.eVs = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.eVt = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.eVr.setOnClickListener(this.aju);
        this.eVs.setOnClickListener(this.aju);
        this.eVt.setOnClickListener(this.aju);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(final tinfo tinfoVar) {
        super.ab(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.bUW.setVisibility(8);
            } else {
                this.bUW.setVisibility(0);
                this.bUW.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.bUW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (aq.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.eVm.setVisibility(8);
            } else {
                this.eVm.setVisibility(0);
                this.eVm.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.eVh.setVisibility(8);
            } else {
                this.eVh.setVisibility(0);
                this.eVh.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.eVi.setVisibility(8);
            } else {
                this.eVi.setVisibility(0);
                this.eVi.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.agq().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.eVq.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.eVt.setVisibility(0);
                        this.eVt.startLoad(str, 10, false);
                        this.eVt.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.eVs.setVisibility(0);
                        this.eVs.startLoad(str2, 10, false);
                        this.eVs.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.eVr.setVisibility(0);
                this.eVr.startLoad(str3, 10, false);
                this.eVr.setTag(0);
                return;
            }
            this.eVq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}

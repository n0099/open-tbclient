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
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes23.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aFf;
    private TextView epn;
    private TextView hXe;
    private TextView hXf;
    private TextView hXj;
    private RelativeLayout hXn;
    private TbImageView hXo;
    private TbImageView hXp;
    private TbImageView hXq;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bzy().dispatchMvcEvent(bVar);
                }
            }
        };
        this.epn = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.hXe = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.hXf = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.hXj = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.hXn = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.hXo = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.hXp = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.hXq = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.hXo.setOnClickListener(this.aFf);
        this.hXp.setOnClickListener(this.aFf);
        this.hXq.setOnClickListener(this.aFf);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(final tinfo tinfoVar) {
        super.au(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.epn.setVisibility(8);
            } else {
                this.epn.setVisibility(0);
                this.epn.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.epn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = tinfoVar.forum_name;
                        if (at.isForumName(str)) {
                            TiebaStatic.eventStat(c.this.getActivity(), "kantie_6", null, 1, new Object[0]);
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(c.this.getActivity()).createNormalCfg(str, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                        }
                    }
                });
            }
            if (StringUtils.isNull(tinfoVar.title)) {
                this.hXj.setVisibility(8);
            } else {
                this.hXj.setVisibility(0);
                this.hXj.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.hXe.setVisibility(8);
            } else {
                this.hXe.setVisibility(0);
                this.hXe.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.hXf.setVisibility(8);
            } else {
                this.hXf.setVisibility(0);
                this.hXf.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bhh().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.hXn.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.hXq.setVisibility(0);
                        this.hXq.startLoad(str, 10, false);
                        this.hXq.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.hXp.setVisibility(0);
                        this.hXp.startLoad(str2, 10, false);
                        this.hXp.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.hXo.setVisibility(0);
                this.hXo.startLoad(str3, 10, false);
                this.hXo.setTag(0);
                return;
            }
            this.hXn.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}

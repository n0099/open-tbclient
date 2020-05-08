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
/* loaded from: classes10.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aOQ;
    private TextView dko;
    private TextView gum;
    private TextView gun;
    private TextView gur;
    private RelativeLayout guv;
    private TbImageView guw;
    private TbImageView gux;
    private TbImageView guy;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.aZc().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dko = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.gum = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.gun = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.gur = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.guv = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.guw = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.gux = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.guy = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.guw.setOnClickListener(this.aOQ);
        this.gux.setOnClickListener(this.aOQ);
        this.guy.setOnClickListener(this.aOQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aj(final tinfo tinfoVar) {
        super.aj(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dko.setVisibility(8);
            } else {
                this.dko.setVisibility(0);
                this.dko.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dko.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.gur.setVisibility(8);
            } else {
                this.gur.setVisibility(0);
                this.gur.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.gum.setVisibility(8);
            } else {
                this.gum.setVisibility(0);
                this.gum.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.gun.setVisibility(8);
            } else {
                this.gun.setVisibility(0);
                this.gun.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (i.aIc().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.guv.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.guy.setVisibility(0);
                        this.guy.startLoad(str, 10, false);
                        this.guy.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.gux.setVisibility(0);
                        this.gux.startLoad(str2, 10, false);
                        this.gux.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.guw.setVisibility(0);
                this.guw.startLoad(str3, 10, false);
                this.guw.setTag(0);
                return;
            }
            this.guv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.c layoutMode = getPageContext().getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(getRootView());
        return true;
    }
}

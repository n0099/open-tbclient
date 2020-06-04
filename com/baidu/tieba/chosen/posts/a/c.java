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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.HotThread.tinfo;
/* loaded from: classes10.dex */
public class c extends com.baidu.tbadk.mvc.f.a<tinfo, com.baidu.tbadk.mvc.d.b> {
    private View.OnClickListener aUZ;
    private TextView dyo;
    private TextView gJi;
    private TextView gJj;
    private TextView gJn;
    private RelativeLayout gJr;
    private TbImageView gJs;
    private TbImageView gJt;
    private TbImageView gJu;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bfn().dispatchMvcEvent(bVar);
                }
            }
        };
        this.dyo = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.gJi = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.gJj = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.gJn = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.gJr = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.gJs = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.gJt = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.gJu = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.gJs.setOnClickListener(this.aUZ);
        this.gJt.setOnClickListener(this.aUZ);
        this.gJu.setOnClickListener(this.aUZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void an(final tinfo tinfoVar) {
        super.an(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.dyo.setVisibility(8);
            } else {
                this.dyo.setVisibility(0);
                this.dyo.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.dyo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.gJn.setVisibility(8);
            } else {
                this.gJn.setVisibility(0);
                this.gJn.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.gJi.setVisibility(8);
            } else {
                this.gJi.setVisibility(0);
                this.gJi.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.gJj.setVisibility(8);
            } else {
                this.gJj.setVisibility(0);
                this.gJj.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.aNQ().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.gJr.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.gJu.setVisibility(0);
                        this.gJu.startLoad(str, 10, false);
                        this.gJu.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.gJt.setVisibility(0);
                        this.gJt.startLoad(str2, 10, false);
                        this.gJt.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.gJs.setVisibility(0);
                this.gJs.startLoad(str3, 10, false);
                this.gJs.setTag(0);
                return;
            }
            this.gJr.setVisibility(8);
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

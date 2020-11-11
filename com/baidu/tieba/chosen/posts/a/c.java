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
    private View.OnClickListener aFV;
    private TextView evg;
    private TextView idb;
    private TextView idc;
    private TextView idg;
    private RelativeLayout idk;
    private TbImageView idm;
    private TbImageView idn;
    private TbImageView ido;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Object tag = view2.getTag();
                if (tag instanceof Integer) {
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), c.this.getData()), null, null);
                    bVar.setUniqueId(c.this.getUniqueId());
                    c.this.bBX().dispatchMvcEvent(bVar);
                }
            }
        };
        this.evg = (TextView) view.findViewById(R.id.chosen_picture_title);
        this.idb = (TextView) view.findViewById(R.id.chosen_picture_praise);
        this.idc = (TextView) view.findViewById(R.id.chosen_picture_comment);
        this.idg = (TextView) view.findViewById(R.id.chosen_picture_head);
        this.idk = (RelativeLayout) view.findViewById(R.id.chosen_picture_pic_container);
        this.idm = (TbImageView) view.findViewById(R.id.chosen_picture_pic_one);
        this.idn = (TbImageView) view.findViewById(R.id.chosen_picture_pic_two);
        this.ido = (TbImageView) view.findViewById(R.id.chosen_picture_pic_thr);
        this.idm.setOnClickListener(this.aFV);
        this.idn.setOnClickListener(this.aFV);
        this.ido.setOnClickListener(this.aFV);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(final tinfo tinfoVar) {
        super.au(tinfoVar);
        if (tinfoVar != null) {
            if (StringUtils.isNull(tinfoVar.forum_name)) {
                this.evg.setVisibility(8);
            } else {
                this.evg.setVisibility(0);
                this.evg.setText(UtilHelper.getFixedText(getContext().getString(R.string.chosen_pb_original_bar, tinfoVar.forum_name), 7, false));
                this.evg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.chosen.posts.a.c.2
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
                this.idg.setVisibility(8);
            } else {
                this.idg.setVisibility(0);
                this.idg.setText(tinfoVar.title);
            }
            if (tinfoVar.zan_num == null) {
                this.idb.setVisibility(8);
            } else {
                this.idb.setVisibility(0);
                this.idb.setText(tinfoVar.zan_num + "");
            }
            if (tinfoVar.reply_num == null) {
                this.idc.setVisibility(8);
            } else {
                this.idc.setVisibility(0);
                this.idc.setText(tinfoVar.reply_num + "");
            }
            b(tinfoVar);
        }
    }

    private void b(tinfo tinfoVar) {
        if (tinfoVar != null) {
            if (k.bjH().isShowImages() && tinfoVar.pics != null && tinfoVar.pics.size() > 0) {
                this.idk.setVisibility(0);
                switch (tinfoVar.pics.size()) {
                    case 0:
                    default:
                        return;
                    case 1:
                        break;
                    case 3:
                        String str = tinfoVar.pics.get(2).small_pic;
                        this.ido.setVisibility(0);
                        this.ido.startLoad(str, 10, false);
                        this.ido.setTag(2);
                    case 2:
                        String str2 = tinfoVar.pics.get(1).small_pic;
                        this.idn.setVisibility(0);
                        this.idn.startLoad(str2, 10, false);
                        this.idn.setTag(1);
                        break;
                }
                String str3 = tinfoVar.pics.get(0).small_pic;
                this.idm.setVisibility(0);
                this.idm.startLoad(str3, 10, false);
                this.idm.setTag(0);
                return;
            }
            this.idk.setVisibility(8);
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

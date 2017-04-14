package com.baidu.tieba.enterForum.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private List<e> aVD;
    private TbPageContext aaX;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aVD = list;
        this.aaX = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVD == null || this.aVD.size() <= 0) {
            return 0;
        }
        return this.aVD.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hk */
    public e getItem(int i) {
        if (this.aVD == null || this.aVD.size() <= 0 || this.aVD.size() <= i) {
            return null;
        }
        return this.aVD.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.aaX.getPageActivity()).inflate(w.j.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bDE = (LinearLayout) view.findViewById(w.h.frequently_forum_info_item);
            aVar2.bDF = (BarImageView) view.findViewById(w.h.frequently_forum_icon);
            aVar2.bDG = (TextView) view.findViewById(w.h.forum_name);
            aVar2.bDH = (ImageView) view.findViewById(w.h.level_info);
            aVar2.bDI = (ImageView) view.findViewById(w.h.sign_icon);
            aVar2.bDJ = (TextView) view.findViewById(w.h.new_thread_count);
            aVar2.bDN = (TextView) view.findViewById(w.h.post_thread_count);
            aVar2.bDK = (HeadImageView) view.findViewById(w.h.post_thread_person_one);
            aVar2.bDL = (HeadImageView) view.findViewById(w.h.post_thread_person_two);
            aVar2.bDM = (HeadImageView) view.findViewById(w.h.post_thread_person_three);
            aVar2.bDO = (LinearLayout) view.findViewById(w.h.new_thread);
            aVar2.bDP = (LinearLayout) view.findViewById(w.h.post_thread);
            aVar2.bDQ = (TextView) view.findViewById(w.h.new_thread_describe);
            aVar2.bDR = (TextView) view.findViewById(w.h.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bDF.c(item.CB(), 10, false);
            aVar.bDG.setText(TbadkCoreApplication.m9getInst().getString(w.l.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            aq.j(aVar.bDH, BitmapHelper.getGradeResourceIdNew(item.CD()));
            if (StringUtils.isNull(item.CC()) || com.baidu.adp.lib.g.b.g(item.CC(), 0) == 0) {
                aVar.bDJ.setVisibility(8);
                aVar.bDQ.setText(this.aaX.getResources().getString(w.l.zero_new_thread_describe));
            } else {
                aVar.bDJ.setVisibility(0);
                aVar.bDQ.setText(this.aaX.getResources().getString(w.l.new_thread_describe));
                aVar.bDJ.setText(au.cT(com.baidu.adp.lib.g.b.g(item.CC(), 0)));
            }
            if (item.isSign()) {
                aVar.bDI.setVisibility(0);
            } else {
                aVar.bDI.setVisibility(8);
            }
            if (item.CE() != null) {
                if (item.CE().size() > 3) {
                    aVar.bDN.setVisibility(0);
                    aVar.bDN.setText("...");
                    aVar.bDR.setText(this.aaX.getResources().getString(w.l.post_thread_describe));
                } else if (item.CE().size() <= 0) {
                    aVar.bDN.setVisibility(8);
                    aVar.bDR.setText(this.aaX.getResources().getString(w.l.attention_users_thread));
                } else {
                    aVar.bDR.setText(this.aaX.getResources().getString(w.l.post_thread_describe));
                    aVar.bDN.setVisibility(8);
                }
                aVar.bDK.setDefaultResource(17170445);
                aVar.bDK.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDK.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDK.setRadius(k.g(this.aaX.getPageActivity(), w.f.ds70));
                aVar.bDL.setDefaultResource(17170445);
                aVar.bDL.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDL.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDL.setRadius(k.g(this.aaX.getPageActivity(), w.f.ds70));
                aVar.bDM.setDefaultResource(17170445);
                aVar.bDM.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bDM.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bDM.setRadius(k.g(this.aaX.getPageActivity(), w.f.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bDK);
            arrayList.add(aVar.bDL);
            arrayList.add(aVar.bDM);
            d(item.CE(), arrayList);
            aa(view);
            aVar.bDP.setTag(item);
            aVar.bDO.setTag(item);
            aVar.bDE.setTag(item);
        }
        aVar.bDP.setOnClickListener(this);
        aVar.bDO.setOnClickListener(this);
        aVar.bDE.setOnClickListener(this);
        return view;
    }

    private void d(List<String> list, List<HeadImageView> list2) {
        if (list != null && list2 != null && list2.size() > 0) {
            int size = list.size();
            int size2 = list2.size();
            for (int i = 0; i < size2; i++) {
                if (list2.get(i) != null) {
                    list2.get(i).setVisibility(8);
                }
            }
            if (size > size2) {
                a(list2.get(0), list.get(0));
                if (list2.size() > 1) {
                    a(list2.get(1), list.get(1));
                }
                if (list2.size() > 2) {
                    a(list2.get(2), list.get(2));
                }
            } else if (size < size2) {
                if (size == 1) {
                    a(list2.get(0), list.get(0));
                } else if (size == 2) {
                    a(list2.get(0), list.get(0));
                    if (list2.size() > 1) {
                        a(list2.get(1), list.get(1));
                    }
                }
            } else {
                a(list2.get(0), list.get(0));
                a(list2.get(1), list.get(1));
                a(list2.get(2), list.get(2));
            }
        }
    }

    private void a(HeadImageView headImageView, String str) {
        if (headImageView != null) {
            headImageView.setVisibility(0);
            headImageView.c(str, 12, false);
        }
    }

    private void aa(View view) {
        this.aaX.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaX.getLayoutMode().t(view);
    }

    public void c(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(0, 0);
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = (listView.getDividerHeight() * (adapter.getCount() - 1)) + i;
            listView.setLayoutParams(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    private class a {
        LinearLayout bDE;
        BarImageView bDF;
        TextView bDG;
        ImageView bDH;
        ImageView bDI;
        TextView bDJ;
        HeadImageView bDK;
        HeadImageView bDL;
        HeadImageView bDM;
        TextView bDN;
        LinearLayout bDO;
        LinearLayout bDP;
        TextView bDQ;
        TextView bDR;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void g(String str, String str2, boolean z) {
        if (au.aB(str2)) {
            this.aaX.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aaX.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !x.q(eVar.CE());
            if (view.getId() == w.h.new_thread) {
                g(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == w.h.post_thread) {
                g(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == w.h.frequently_forum_info_item) {
                g(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}

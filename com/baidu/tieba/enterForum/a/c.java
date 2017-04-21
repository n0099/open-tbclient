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
    private List<e> aVF;
    private TbPageContext aaY;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aVF = list;
        this.aaY = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aVF == null || this.aVF.size() <= 0) {
            return 0;
        }
        return this.aVF.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hq */
    public e getItem(int i) {
        if (this.aVF == null || this.aVF.size() <= 0 || this.aVF.size() <= i) {
            return null;
        }
        return this.aVF.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.aaY.getPageActivity()).inflate(w.j.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bFV = (LinearLayout) view.findViewById(w.h.frequently_forum_info_item);
            aVar2.bFW = (BarImageView) view.findViewById(w.h.frequently_forum_icon);
            aVar2.bFX = (TextView) view.findViewById(w.h.forum_name);
            aVar2.bFY = (ImageView) view.findViewById(w.h.level_info);
            aVar2.bFZ = (ImageView) view.findViewById(w.h.sign_icon);
            aVar2.bGa = (TextView) view.findViewById(w.h.new_thread_count);
            aVar2.bGe = (TextView) view.findViewById(w.h.post_thread_count);
            aVar2.bGb = (HeadImageView) view.findViewById(w.h.post_thread_person_one);
            aVar2.bGc = (HeadImageView) view.findViewById(w.h.post_thread_person_two);
            aVar2.bGd = (HeadImageView) view.findViewById(w.h.post_thread_person_three);
            aVar2.bGf = (LinearLayout) view.findViewById(w.h.new_thread);
            aVar2.bGg = (LinearLayout) view.findViewById(w.h.post_thread);
            aVar2.bGh = (TextView) view.findViewById(w.h.new_thread_describe);
            aVar2.bGi = (TextView) view.findViewById(w.h.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bFW.c(item.CB(), 10, false);
            aVar.bFX.setText(TbadkCoreApplication.m9getInst().getString(w.l.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            aq.j(aVar.bFY, BitmapHelper.getGradeResourceIdNew(item.CD()));
            if (StringUtils.isNull(item.CC()) || com.baidu.adp.lib.g.b.g(item.CC(), 0) == 0) {
                aVar.bGa.setVisibility(8);
                aVar.bGh.setText(this.aaY.getResources().getString(w.l.zero_new_thread_describe));
            } else {
                aVar.bGa.setVisibility(0);
                aVar.bGh.setText(this.aaY.getResources().getString(w.l.new_thread_describe));
                aVar.bGa.setText(au.cT(com.baidu.adp.lib.g.b.g(item.CC(), 0)));
            }
            if (item.isSign()) {
                aVar.bFZ.setVisibility(0);
            } else {
                aVar.bFZ.setVisibility(8);
            }
            if (item.CE() != null) {
                if (item.CE().size() > 3) {
                    aVar.bGe.setVisibility(0);
                    aVar.bGe.setText("...");
                    aVar.bGi.setText(this.aaY.getResources().getString(w.l.post_thread_describe));
                } else if (item.CE().size() <= 0) {
                    aVar.bGe.setVisibility(8);
                    aVar.bGi.setText(this.aaY.getResources().getString(w.l.attention_users_thread));
                } else {
                    aVar.bGi.setText(this.aaY.getResources().getString(w.l.post_thread_describe));
                    aVar.bGe.setVisibility(8);
                }
                aVar.bGb.setDefaultResource(17170445);
                aVar.bGb.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bGb.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bGb.setRadius(k.g(this.aaY.getPageActivity(), w.f.ds70));
                aVar.bGc.setDefaultResource(17170445);
                aVar.bGc.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bGc.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bGc.setRadius(k.g(this.aaY.getPageActivity(), w.f.ds70));
                aVar.bGd.setDefaultResource(17170445);
                aVar.bGd.setDefaultErrorResource(w.g.icon_default_avatar100);
                aVar.bGd.setDefaultBgResource(w.e.cp_bg_line_e);
                aVar.bGd.setRadius(k.g(this.aaY.getPageActivity(), w.f.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bGb);
            arrayList.add(aVar.bGc);
            arrayList.add(aVar.bGd);
            d(item.CE(), arrayList);
            aa(view);
            aVar.bGg.setTag(item);
            aVar.bGf.setTag(item);
            aVar.bFV.setTag(item);
        }
        aVar.bGg.setOnClickListener(this);
        aVar.bGf.setOnClickListener(this);
        aVar.bFV.setOnClickListener(this);
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
        this.aaY.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.aaY.getLayoutMode().t(view);
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
        LinearLayout bFV;
        BarImageView bFW;
        TextView bFX;
        ImageView bFY;
        ImageView bFZ;
        TextView bGa;
        HeadImageView bGb;
        HeadImageView bGc;
        HeadImageView bGd;
        TextView bGe;
        LinearLayout bGf;
        LinearLayout bGg;
        TextView bGh;
        TextView bGi;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void g(String str, String str2, boolean z) {
        if (au.aB(str2)) {
            this.aaY.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.aaY.getPageActivity()).createNormalCfg(str2, str, z)));
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

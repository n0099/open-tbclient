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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private TbPageContext Gd;
    private List<e> aSU;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aSU = list;
        this.Gd = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aSU == null || this.aSU.size() <= 0) {
            return 0;
        }
        return this.aSU.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ho */
    public e getItem(int i) {
        if (this.aSU == null || this.aSU.size() <= 0 || this.aSU.size() <= i) {
            return null;
        }
        return this.aSU.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(r.h.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bFV = (LinearLayout) view.findViewById(r.g.frequently_forum_info_item);
            aVar2.bFW = (BarImageView) view.findViewById(r.g.frequently_forum_icon);
            aVar2.bFX = (TextView) view.findViewById(r.g.forum_name);
            aVar2.bFY = (ImageView) view.findViewById(r.g.level_info);
            aVar2.bFZ = (ImageView) view.findViewById(r.g.sign_icon);
            aVar2.bGa = (TextView) view.findViewById(r.g.new_thread_count);
            aVar2.bGe = (TextView) view.findViewById(r.g.post_thread_count);
            aVar2.bGb = (HeadImageView) view.findViewById(r.g.post_thread_person_one);
            aVar2.bGc = (HeadImageView) view.findViewById(r.g.post_thread_person_two);
            aVar2.bGd = (HeadImageView) view.findViewById(r.g.post_thread_person_three);
            aVar2.bGf = (LinearLayout) view.findViewById(r.g.new_thread);
            aVar2.bGg = (LinearLayout) view.findViewById(r.g.post_thread);
            aVar2.bGh = (TextView) view.findViewById(r.g.new_thread_describe);
            aVar2.bGi = (TextView) view.findViewById(r.g.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bFW.c(item.BW(), 10, false);
            aVar.bFX.setText(TbadkCoreApplication.m9getInst().getString(r.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            av.k(aVar.bFY, BitmapHelper.getGradeResourceIdNew(item.BY()));
            if (StringUtils.isNull(item.BX()) || com.baidu.adp.lib.h.b.g(item.BX(), 0) == 0) {
                aVar.bGa.setVisibility(8);
                aVar.bGh.setText(this.Gd.getResources().getString(r.j.zero_new_thread_describe));
            } else {
                aVar.bGa.setVisibility(0);
                aVar.bGh.setText(this.Gd.getResources().getString(r.j.new_thread_describe));
                aVar.bGa.setText(az.cS(com.baidu.adp.lib.h.b.g(item.BX(), 0)));
            }
            if (item.isSign()) {
                aVar.bFZ.setVisibility(0);
            } else {
                aVar.bFZ.setVisibility(8);
            }
            if (item.BZ() != null) {
                if (item.BZ().size() > 3) {
                    aVar.bGe.setVisibility(0);
                    aVar.bGe.setText("...");
                    aVar.bGi.setText(this.Gd.getResources().getString(r.j.post_thread_describe));
                } else if (item.BZ().size() <= 0) {
                    aVar.bGe.setVisibility(8);
                    aVar.bGi.setText(this.Gd.getResources().getString(r.j.attention_users_thread));
                } else {
                    aVar.bGi.setText(this.Gd.getResources().getString(r.j.post_thread_describe));
                    aVar.bGe.setVisibility(8);
                }
                aVar.bGb.setDefaultResource(17170445);
                aVar.bGb.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.bGb.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.bGb.setRadius(k.e(this.Gd.getPageActivity(), r.e.ds70));
                aVar.bGc.setDefaultResource(17170445);
                aVar.bGc.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.bGc.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.bGc.setRadius(k.e(this.Gd.getPageActivity(), r.e.ds70));
                aVar.bGd.setDefaultResource(17170445);
                aVar.bGd.setDefaultErrorResource(r.f.icon_default_avatar100);
                aVar.bGd.setDefaultBgResource(r.d.cp_bg_line_e);
                aVar.bGd.setRadius(k.e(this.Gd.getPageActivity(), r.e.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bGb);
            arrayList.add(aVar.bGc);
            arrayList.add(aVar.bGd);
            f(item.BZ(), arrayList);
            W(view);
            aVar.bGg.setTag(item);
            aVar.bGf.setTag(item);
            aVar.bFV.setTag(item);
        }
        aVar.bGg.setOnClickListener(this);
        aVar.bGf.setOnClickListener(this);
        aVar.bFV.setOnClickListener(this);
        return view;
    }

    private void f(List<String> list, List<HeadImageView> list2) {
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

    private void W(View view) {
        this.Gd.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.Gd.getLayoutMode().x(view);
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

    private void e(String str, String str2, boolean z) {
        if (az.aN(str2)) {
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Gd.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !y.t(eVar.BZ());
            if (view.getId() == r.g.new_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.g.post_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == r.g.frequently_forum_info_item) {
                e(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}

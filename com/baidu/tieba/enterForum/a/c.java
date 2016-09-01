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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.data.e;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private TbPageContext Gd;
    private List<e> aRP;

    public void a(List<e> list, TbPageContext<?> tbPageContext) {
        this.aRP = list;
        this.Gd = tbPageContext;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aRP == null || this.aRP.size() <= 0) {
            return 0;
        }
        return this.aRP.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: hk */
    public e getItem(int i) {
        if (this.aRP == null || this.aRP.size() <= 0 || this.aRP.size() <= i) {
            return null;
        }
        return this.aRP.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.Gd.getPageActivity()).inflate(t.h.frequently_forum_info_item, (ViewGroup) null);
            a aVar2 = new a(this, null);
            aVar2.bFK = (LinearLayout) view.findViewById(t.g.frequently_forum_info_item);
            aVar2.bFL = (BarImageView) view.findViewById(t.g.frequently_forum_icon);
            aVar2.bFM = (TextView) view.findViewById(t.g.forum_name);
            aVar2.bFN = (ImageView) view.findViewById(t.g.level_info);
            aVar2.bFO = (ImageView) view.findViewById(t.g.sign_icon);
            aVar2.bFP = (TextView) view.findViewById(t.g.new_thread_count);
            aVar2.bFT = (TextView) view.findViewById(t.g.post_thread_count);
            aVar2.bFQ = (HeadImageView) view.findViewById(t.g.post_thread_person_one);
            aVar2.bFR = (HeadImageView) view.findViewById(t.g.post_thread_person_two);
            aVar2.bFS = (HeadImageView) view.findViewById(t.g.post_thread_person_three);
            aVar2.bFU = (LinearLayout) view.findViewById(t.g.new_thread);
            aVar2.bFV = (LinearLayout) view.findViewById(t.g.post_thread);
            aVar2.bFW = (TextView) view.findViewById(t.g.new_thread_describe);
            aVar2.bFX = (TextView) view.findViewById(t.g.post_thread_describe);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        e item = getItem(i);
        if (item != null) {
            aVar.bFL.c(item.BT(), 10, false);
            aVar.bFM.setText(TbadkCoreApplication.m9getInst().getString(t.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(item.getForumName(), 6, true)}));
            av.k(aVar.bFN, BitmapHelper.getGradeResourceIdNew(item.BV()));
            if (StringUtils.isNull(item.BU()) || com.baidu.adp.lib.h.b.g(item.BU(), 0) == 0) {
                aVar.bFP.setVisibility(8);
                aVar.bFW.setText(this.Gd.getResources().getString(t.j.zero_new_thread_describe));
            } else {
                aVar.bFP.setVisibility(0);
                aVar.bFW.setText(this.Gd.getResources().getString(t.j.new_thread_describe));
                aVar.bFP.setText(ba.cS(com.baidu.adp.lib.h.b.g(item.BU(), 0)));
            }
            if (item.isSign()) {
                aVar.bFO.setVisibility(0);
            } else {
                aVar.bFO.setVisibility(8);
            }
            if (item.BW() != null) {
                if (item.BW().size() > 3) {
                    aVar.bFT.setVisibility(0);
                    aVar.bFT.setText("...");
                    aVar.bFX.setText(this.Gd.getResources().getString(t.j.post_thread_describe));
                } else if (item.BW().size() <= 0) {
                    aVar.bFT.setVisibility(8);
                    aVar.bFX.setText(this.Gd.getResources().getString(t.j.zero_post_thread_describe));
                } else {
                    aVar.bFX.setText(this.Gd.getResources().getString(t.j.post_thread_describe));
                    aVar.bFT.setVisibility(8);
                }
                aVar.bFQ.setDefaultResource(17170445);
                aVar.bFQ.setDefaultErrorResource(t.f.icon_default_avatar100);
                aVar.bFQ.setDefaultBgResource(t.d.cp_bg_line_e);
                aVar.bFQ.setRadius(k.e(this.Gd.getPageActivity(), t.e.ds70));
                aVar.bFR.setDefaultResource(17170445);
                aVar.bFR.setDefaultErrorResource(t.f.icon_default_avatar100);
                aVar.bFR.setDefaultBgResource(t.d.cp_bg_line_e);
                aVar.bFR.setRadius(k.e(this.Gd.getPageActivity(), t.e.ds70));
                aVar.bFS.setDefaultResource(17170445);
                aVar.bFS.setDefaultErrorResource(t.f.icon_default_avatar100);
                aVar.bFS.setDefaultBgResource(t.d.cp_bg_line_e);
                aVar.bFS.setRadius(k.e(this.Gd.getPageActivity(), t.e.ds70));
            }
            List<HeadImageView> arrayList = new ArrayList<>();
            arrayList.add(aVar.bFQ);
            arrayList.add(aVar.bFR);
            arrayList.add(aVar.bFS);
            d(item.BW(), arrayList);
            W(view);
            aVar.bFV.setTag(item);
            aVar.bFU.setTag(item);
            aVar.bFK.setTag(item);
        }
        aVar.bFV.setOnClickListener(this);
        aVar.bFU.setOnClickListener(this);
        aVar.bFK.setOnClickListener(this);
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
        LinearLayout bFK;
        BarImageView bFL;
        TextView bFM;
        ImageView bFN;
        ImageView bFO;
        TextView bFP;
        HeadImageView bFQ;
        HeadImageView bFR;
        HeadImageView bFS;
        TextView bFT;
        LinearLayout bFU;
        LinearLayout bFV;
        TextView bFW;
        TextView bFX;

        private a() {
        }

        /* synthetic */ a(c cVar, a aVar) {
            this();
        }
    }

    private void e(String str, String str2, boolean z) {
        if (ba.aN(str2)) {
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.Gd.getPageActivity()).createNormalCfg(str2, str, z)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (view != null && (view.getTag() instanceof e) && (eVar = (e) view.getTag()) != null) {
            boolean z = !y.t(eVar.BW());
            if (view.getId() == t.g.new_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLT_FORUM_NEW_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == t.g.post_thread) {
                e(FrsActivityConfig.FRS_FROM_FREQUENTLY_FORUM_POST_THREAD, eVar.getForumName(), z);
            } else if (view.getId() == t.g.frequently_forum_info_item) {
                e(FrsActivityConfig.FRS_FORUM_FREQUENTLY_FORUM, eVar.getForumName(), z);
            }
        }
    }
}

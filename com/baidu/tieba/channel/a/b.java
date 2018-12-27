package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity dcN;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.dcN = channelFansActivity;
    }

    public void setData(List<i> list) {
        this.mData = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kT */
    public i getItem(int i) {
        if (this.mData != null) {
            return this.mData.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.dcN.getPageContext().getPageActivity()).inflate(e.h.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.dcO = (HeadImageView) view.findViewById(e.g.avatar);
            aVar2.dcO.setAutoChangeStyle(true);
            aVar2.dcO.setIsRound(true);
            aVar2.dcO.setClickable(false);
            aVar2.dcP = (TextView) view.findViewById(e.g.fans_name);
            aVar2.dcQ = (TextView) view.findViewById(e.g.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.dcO.setTag(null);
                aVar.dcO.setDefaultResource(e.f.img_default_100);
                aVar.dcO.startLoad(item.getPortrait(), 12, false);
                aVar.dcO.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.dcP.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.dcQ.setText(item.getIntro());
            }
        }
        this.dcN.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.dcN.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        HeadImageView dcO;
        TextView dcP;
        TextView dcQ;

        private a() {
        }
    }
}

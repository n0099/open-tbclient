package com.baidu.tieba.channel.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.activity.ChannelFansActivity;
import com.baidu.tieba.channel.data.i;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private ChannelFansActivity eJH;
    private List<i> mData;

    public b(ChannelFansActivity channelFansActivity) {
        this.eJH = channelFansActivity;
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
    /* renamed from: pR */
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
            view = LayoutInflater.from(this.eJH.getPageContext().getPageActivity()).inflate(R.layout.channel_fans_list_item_layout, viewGroup, false);
            a aVar2 = new a();
            aVar2.eJI = (HeadImageView) view.findViewById(R.id.avatar);
            aVar2.eJI.setAutoChangeStyle(true);
            aVar2.eJI.setIsRound(true);
            aVar2.eJI.setClickable(false);
            aVar2.eJJ = (TextView) view.findViewById(R.id.fans_name);
            aVar2.eJK = (TextView) view.findViewById(R.id.fans_intro);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        i item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getPortrait())) {
                aVar.eJI.setTag(null);
                aVar.eJI.setDefaultResource(R.drawable.img_default_100);
                aVar.eJI.startLoad(item.getPortrait(), 12, false);
                aVar.eJI.invalidate();
            }
            if (!TextUtils.isEmpty(item.getUser_name())) {
                aVar.eJJ.setText(item.getUser_name());
            }
            if (!TextUtils.isEmpty(item.getIntro())) {
                aVar.eJK.setText(item.getIntro());
            }
        }
        this.eJH.getLayoutMode().setNightMode(TbadkCoreApplication.getInst().getSkinType() == 1);
        this.eJH.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* loaded from: classes6.dex */
    private class a {
        HeadImageView eJI;
        TextView eJJ;
        TextView eJK;

        private a() {
        }
    }
}

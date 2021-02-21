package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<com.baidu.tbadk.mvc.b.a> ajo = new ArrayList<>();
    private c kCL;
    private TbPageContext<?> mPageContext;

    /* loaded from: classes8.dex */
    public interface c {
        void a(View view, Object obj, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        this.mPageContext = tbPageContext;
        this.kCL = cVar;
    }

    public void setData(ArrayList<? extends com.baidu.tbadk.mvc.b.a> arrayList) {
        if (arrayList != null) {
            this.ajo.clear();
            this.ajo.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.mPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (this.ajo != null && this.ajo.size() > 0) {
            com.baidu.tbadk.mvc.b.a aVar = this.ajo.get(i);
            if ((viewHolder instanceof b) && (aVar instanceof a)) {
                ((b) viewHolder).b(aVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.ajo == null) {
            return 0;
        }
        return this.ajo.size();
    }

    /* loaded from: classes8.dex */
    class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView jPC;
        private BarImageView kCN;
        private View kCO;
        private a kCP;

        b(View view) {
            super(view);
            this.kCN = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.jPC = (TextView) view.findViewById(R.id.official_bar_name);
            this.kCO = view.findViewById(R.id.official_bar_feed_red_dot);
            this.kCN.setShowOval(true);
            this.kCN.setPlaceHolder(2);
            this.kCN.setShowOuterBorder(false);
            this.kCN.setShowInnerBorder(true);
            this.kCN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        void b(com.baidu.tbadk.mvc.b.a aVar) {
            this.kCP = (a) aVar;
            ap.setViewTextColor(this.jPC, R.color.CAM_X0105);
            ap.setBackgroundResource(this.kCO, R.drawable.icon_official_bar_red_dot);
            this.kCN.setStrokeColorResId(R.color.CAM_X0401);
            this.kCN.startLoad(this.kCP.cUY(), 10, false);
            if (au.getChineseAndEnglishLength(this.kCP.cPn()) <= 10) {
                this.jPC.setText(this.kCP.cPn());
            } else {
                this.jPC.setText(au.cutChineseAndEnglishWithSuffix(this.kCP.cPn(), 8, StringHelper.STRING_MORE));
            }
            this.kCN.setOnClickListener(this);
            if (this.kCP.getUnReadCount() > 0 && (this.kCP.cUZ() <= 0 || System.currentTimeMillis() - this.kCP.cUZ() < 864000000)) {
                this.kCO.setVisibility(0);
            } else {
                this.kCO.setVisibility(8);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.kCO.setVisibility(8);
            if (OfficialBarFeedMsglistAdapter.this.kCL != null) {
                OfficialBarFeedMsglistAdapter.this.kCL.a(view, this.kCP, getAdapterPosition(), getItemId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a implements com.baidu.tbadk.mvc.b.a {
        private long cZf;
        private long groupId;
        private String kCM;
        private String kbW;
        private int unReadCount;
        private int userType;

        String cUY() {
            return this.kCM;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String cPn() {
            return this.kbW;
        }

        int getUnReadCount() {
            return this.unReadCount;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Mt(String str) {
            this.kCM = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void Mu(String str) {
            this.kbW = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setUnReadCount(int i) {
            this.unReadCount = i;
        }

        public void setGroupId(long j) {
            this.groupId = j;
        }

        public void setUserType(int i) {
            this.userType = i;
        }

        public long getGroupId() {
            return this.groupId;
        }

        public long cUZ() {
            return this.cZf;
        }

        public void gP(long j) {
            this.cZf = j;
        }
    }
}

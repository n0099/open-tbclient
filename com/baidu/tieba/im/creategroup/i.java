package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class i implements o {
    CreateGroupStepActivity iNW;
    private int iOa;
    HeadImageView iOw;
    ImageView iOx;
    TextView iOy;
    private int mIndex;
    private int mStep;
    View mView;
    private com.baidu.adp.widget.ImageView.a iOz = null;
    private a iOA = null;

    public i(CreateGroupStepActivity createGroupStepActivity, int i, int i2, int i3) {
        this.iNW = null;
        this.mView = null;
        this.iOw = null;
        this.iOx = null;
        this.iOy = null;
        this.iNW = createGroupStepActivity;
        this.mView = LayoutInflater.from(createGroupStepActivity.getPageContext().getPageActivity()).inflate(R.layout.create_group_step3_view, (ViewGroup) null);
        this.iOx = (ImageView) this.mView.findViewById(R.id.step3_img_bg);
        this.iOw = (HeadImageView) this.mView.findViewById(R.id.step3_img_scr);
        this.iOy = (TextView) this.mView.findViewById(R.id.create_group3);
        this.mIndex = i;
        this.mStep = i2;
        this.iOa = i3;
    }

    public void cow() {
        if (this.iOA != null) {
            this.iOA.cancel();
        }
        this.iOz = null;
        this.iOA = new a();
        this.iOA.execute(new Object[0]);
    }

    public ImageView cox() {
        return this.iOx;
    }

    public TextView coy() {
        return this.iOy;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public View getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void cog() {
        this.iOx.setBackgroundDrawable(null);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public void coh() {
        this.iNW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iNW.getLayoutMode().onModeChanged(this.mView);
        this.iOw.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.getImage(null, TbConfig.GROUP_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            if (bitmap != null) {
                i.this.iOw.setVisibility(0);
                i.this.iOz = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                i.this.iOz.drawImageTo(i.this.iOw);
            }
        }
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getTitle() {
        return String.format(this.iNW.getPageContext().getString(R.string.group_create_step_photo), Integer.valueOf(this.mStep));
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String coj() {
        if (this.mIndex != this.iOa) {
            return this.iNW.getPageContext().getString(R.string.next_step);
        }
        return this.iNW.getPageContext().getString(R.string.group_create_step_done_tip);
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean cok() {
        return true;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public int coa() {
        return this.mIndex;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public String getErrMsg() {
        return null;
    }

    @Override // com.baidu.tieba.im.creategroup.o
    public boolean col() {
        return true;
    }
}

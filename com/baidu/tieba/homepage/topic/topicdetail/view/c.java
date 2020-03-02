package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends l {
    private EditText dyD;

    public c(Context context) {
        super(context, (String) null, 29);
        this.dxs = false;
        this.dxr = 3;
        this.dwA = new TopicDetaiInputContainer(context);
        this.dyD = ((TopicDetaiInputContainer) this.dwA).getInputView();
        ((TopicDetaiInputContainer) this.dwA).setHint(context.getString(R.string.say_your_point));
        this.dxt = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.dyD;
    }
}
